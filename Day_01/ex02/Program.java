package ex02;

public class Program {
    public static void main(String[] args) {
        User u1 = new User("John", 500);
        User u2 = new User("Bob1", 1000);
        User u3 = new User("Bob2", 1000);
        User u4 = new User("Bob3", 1000);
        User u5 = new User("Bob4", 1000);
        User u6 = new User("Bob5", 1000);
        User u7 = new User("Bob6", 1000);
        User u8 = new User("Bob7", 1000);
        User u9 = new User("Bob8", 1000);
        User u10= new User("Bob9", 1000);
        User u11= new User("Bob10", 1000);

        UsersArrayList users_list = new UsersArrayList();
        users_list.addUser(u1);
        users_list.addUser(u2);
        System.out.println(users_list.getAmountUsers());
        System.out.println(users_list.getUserById(1).getBalanse());
        System.out.println(users_list.getUserByIdx(1).getBalanse());
        users_list.addUser(u3);
        users_list.addUser(u4);
        users_list.addUser(u5);
        users_list.addUser(u6);
        users_list.addUser(u7);
        users_list.addUser(u8);
        users_list.addUser(u9);
        users_list.addUser(u10);
        users_list.addUser(u11);
        System.out.println(users_list.getAmountUsers());
        System.out.println(users_list.getUserByIdx(1).getName());
        System.out.println(users_list.getUserByIdx(10).getName());
        }
}
