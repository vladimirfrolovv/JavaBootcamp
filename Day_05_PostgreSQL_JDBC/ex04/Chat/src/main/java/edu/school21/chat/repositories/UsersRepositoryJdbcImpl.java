package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private DataSource dataSource;

    public UsersRepositoryJdbcImpl ( DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    private final String query = "WITH filter_query AS (SELECT u.id user_id, login, password, (ROW_NUMBER() OVER (ORDER BY u.id)) AS filter FROM chat.users u), result_users AS (SELECT user_id, login, password FROM filter_query WHERE filter > ? LIMIT ?)\n" +
            "SELECT user_id, login, password, r.id rm_id, r.chat_name, m.id owner\n" +
            "FROM result_users res LEFT JOIN chat.message m on res.user_id = m.sender LEFT JOIN chat.room r on res.user_id = r.chat_creator;";

    @Override
    public List<User> findAll ( int page, int size ) {
        LinkedList<User> result = new LinkedList<>();

        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, page * size);
            preparedStatement.setInt(2, size);
            ResultSet resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                User user = new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), null, null);
                if (result.isEmpty() || !user.equals(result.getLast())) {
                    result.add(user);
                }
                Chatroom chatroom = new Chatroom(resultSet.getLong(4), resultSet.getString(5), null, null);

                result.getLast().addCreateRoom(chatroom);
                result.getLast().addUsRoom(chatroom);

            }
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Bad Query");
        }
        return result;
    }
}
