package ex02;

public class UserIdsGenerator {
    public static final UserIdsGenerator INSTANCE = new UserIdsGenerator();
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
