package ex03;

public class UserIdsGenerator {
    public static final UserIdsGenerator INSTANCE = new UserIdsGenerator();
    private static int Id = 0;
    private UserIdsGenerator(){};
    public static UserIdsGenerator getInstance() {
        return INSTANCE;
    }
    public int generateId() {
        Id++;
        return Id;
    }
}
