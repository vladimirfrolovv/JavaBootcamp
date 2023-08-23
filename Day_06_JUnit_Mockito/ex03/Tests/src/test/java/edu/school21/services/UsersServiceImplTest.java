package edu.school21.services;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class UsersServiceImplTest {
    private UsersServiceImpl usersService;
    private UsersRepository usersRepository = Mockito.mock(UsersRepository.class);

    @BeforeEach
    public void setUp ( ) {
        usersRepository = Mockito.mock(UsersRepository.class);
        User user = new User(1, "user1", "password1", false);
        User user_logged = new User(2, "user2", "password2", true);
        when(usersRepository.findByLogin("user2")).thenReturn(user_logged);
        when(usersRepository.findByLogin("user6")).thenReturn(null);

        when(usersRepository.findByLogin("user1")).thenReturn(user);
        usersService = new UsersServiceImpl(usersRepository);
    }

    @Test
    public void testAuthenticateSuccessful ( ) throws SQLException {
        boolean result = usersService.authenticate("user1", "password1");
        Assertions.assertTrue(result);

    }

    @Test
    public void testAuthenticateFail ( ) throws SQLException {
        boolean result = usersService.authenticate("user6", "password1");
        Assertions.assertFalse(result);
    }
    @Test
    public void testAuthenticatePassword ( ) throws SQLException {
        boolean result = usersService.authenticate("user1", "password3");
        Assertions.assertFalse(result);
    }

    @Test
    public void testAuthenticateAlready ( ) throws SQLException {
        Assertions.assertThrows(AlreadyAuthenticatedException.class, ( ) -> usersService.authenticate("user2", "password2"));
    }


}
