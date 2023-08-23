package edu.school21.services;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersServiceImpl {
    private UsersRepository usersRepository;

    public UsersServiceImpl ( UsersRepository usersRepository ) {
        this.usersRepository = usersRepository;
    }


    public boolean authenticate ( String login, String password ) {
        User user = usersRepository.findByLogin(login);
        if (user == null) {
            return false;
        }
        if (user.getStatusAuth()) {
            throw new AlreadyAuthenticatedException("User already authenticated");
        }
        if (password.equals(user.getPassword())) {
            user.setStatusAuth(true);
            usersRepository.update(user);
            return true;
        } else {
            return false;
        }

    }
}

