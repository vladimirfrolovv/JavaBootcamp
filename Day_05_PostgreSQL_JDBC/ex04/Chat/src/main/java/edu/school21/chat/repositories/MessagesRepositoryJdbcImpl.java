package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final DataSource dataSource;
    private final String selectQuery = "SELECT * FROM chat.message WHERE id = ?";
    private String insertQuery = "INSERT INTO chat.message (room_id, sender, text_message, time) VALUES ( ?, ?, ?, ?);";
    private String updateQuery = "UPDATE chat.message SET sender = ?, room_id = ?, text_message = ?, time = ? WHERE id = ?;";

    public MessagesRepositoryJdbcImpl ( DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById ( Long id ) throws SQLException {
        Optional<Message> optionalMessage = Optional.empty();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            User user = new User(1L, "user1", "pass1", null, null);
            Chatroom chatroom = new Chatroom(1L, "chatroom", null, null);
            optionalMessage = Optional.of(new Message(resultSet.getLong(1), user, chatroom, resultSet.getString("text_message"), resultSet.getTimestamp("time")));
        } catch (SQLException e) {
            e.getMessage();
        }
        return optionalMessage;
    }

    @Override
    public void save ( Message message ) throws NotSavedSubEntityException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(2, message.getUser().getId());
            preparedStatement.setLong(1, message.getChatroom().getId());
            preparedStatement.setString(3, message.getTextMessage());
            preparedStatement.setTimestamp(4, message.getDateTime());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            message.setId(resultSet.getLong(1));

        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Bad Query");
        }
    }

    @Override
    public void update ( Message message ) throws NotSavedSubEntityException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            if (message.getDateTime() == null) {
                preparedStatement.setNull(4, Types.TIMESTAMP);
            } else {
                preparedStatement.setTimestamp(4, message.getDateTime());
            }
            if (message.getUser().getId() < 0) {
                preparedStatement.setNull(1, Types.INTEGER);
            } else {
                preparedStatement.setLong(1, message.getUser().getId());
            }

            if (message.getChatroom().getId() < 0) {
                preparedStatement.setNull(2, Types.INTEGER);
            } else {
                preparedStatement.setLong(2, message.getChatroom().getId());
            }
            preparedStatement.setString(3, message.getTextMessage());
            preparedStatement.setLong(5, message.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Bad Query");
        }
    }
}
