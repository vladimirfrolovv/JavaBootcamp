package edu.school21.chat.app;


import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.UsersRepository;
import edu.school21.chat.repositories.UsersRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main ( String[] args ) throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        UsersRepository repository = new UsersRepositoryJdbcImpl(dataSource);

        List<User> list_us;
        list_us = repository.findAll(1, 1);
        for (User user : list_us) {
            System.out.println(user.toString());
        }



    }

}
