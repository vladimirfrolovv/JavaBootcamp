package ex01;

public class UserIdsGenerator {
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();
    private int Id = 0;
    private UserIdsGenerator(){};
    public static UserIdsGenerator getInstance() {
        return INSTANCE;
    }
    public int generateId() {
        Id++;
        return Id;
    }
}
