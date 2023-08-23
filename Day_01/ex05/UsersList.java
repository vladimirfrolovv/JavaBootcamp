package ex05;


public interface UsersList {
    public void addUser( User us);
    public User getUserById( int Id) throws UserNotFoundException;
    public User getUserByIdx( int idx) throws UserNotFoundException;
    public int getAmountUsers();
}
