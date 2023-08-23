package edu.school21.chat.app;


import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main ( String[] args ) throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message ID");
        System.out.print("-> ");
        try {
            Optional<Message> buId = messagesRepository.findById(scanner.nextLong());
            System.out.println(buId.get());

        } catch (SQLException e) {
            e.getMessage();
        }

    }

}
