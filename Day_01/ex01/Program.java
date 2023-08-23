package ex01;

public class Program {
    public static void main(String[] args) {
        User u1 = new User("John", 500);
        User u2 = new User("Bob", 1000);
        System.out.println(u1.getIdentifier());
        System.out.println(u2.getIdentifier());
        User u3 = new User("Bob", 1000);
        System.out.println(u3.getIdentifier());
    }
}
