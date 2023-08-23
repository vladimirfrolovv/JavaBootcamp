package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final DataSource dataSource;
    private final String selectQuery = "SELECT * FROM chat.message WHERE id = ?";

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
}
