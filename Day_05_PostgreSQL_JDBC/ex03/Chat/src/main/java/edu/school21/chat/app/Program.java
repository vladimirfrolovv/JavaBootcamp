package edu.school21.chat.app;


import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main ( String[] args ) throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource);

        User user = new User(1L, "user1", "pass1", new ArrayList<>(), new ArrayList<>());
        Chatroom chatroom = new Chatroom(1L, "Chatroom A", user, new ArrayList<>());
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        Message message = new Message(1L , user, chatroom, "new sa", Timestamp.valueOf(LocalDateTime.now()));
        repository.update(message);


    }

}
