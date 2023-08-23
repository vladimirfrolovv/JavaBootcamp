package ex04;


public class UsersArrayList implements UsersList {
    private User[] users = new User[10];
    private int capacity = 10;
    private int size = 0;
    @Override
    public void addUser( User us) {
        if (size == capacity - 1) {
            User[] tmp = new User[capacity];
            tmp = users;
            users = new User[capacity * 2];
            capacity *= 2;
            for(int i = 0; i < capacity / 2; ++i){
                users[i] = tmp[i];
            }
            size++;
        } else {
            users[size] = us;
            size++;
        }
    }
    @Override
    public User getUserById( int Id) throws UserNotFoundException {
          for (int i = 0; i < size; ++i) {
              if (users[i].getIdentifier() == Id) {
                  return users[i];
              }
          }
          throw new UserNotFoundException("User Not Found On This Id");
    }
    @Override
    public User getUserByIdx( int idx){
        return users[idx];
    }
    @Override
    public int getAmountUsers() {
        return size;
    }
}
