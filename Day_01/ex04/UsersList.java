package ex04;


public interface UsersList {
     void addUser( User us);
     User getUserById( int Id);
     User getUserByIdx( int idx);
     int getAmountUsers();
}
