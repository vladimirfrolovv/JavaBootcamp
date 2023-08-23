package ex00;

public class Program {
    public static void main(String[] args) {
       User u1 = new User(1,"John", 2500);
       User u2 = new User(2, "Bob", 1500);
        User u3 = new User(2, "Bob", 500);
       Transaction t1 = new Transaction(u1, u2,-500, Transaction.TransferCategory.CREDITS);
       Transaction t2 = new Transaction(u1, u2,500, Transaction.TransferCategory.DEBITS);
        Transaction t3 = new Transaction(u1, u2,-500, Transaction.TransferCategory.CREDITS);
       System.out.println(t1.getCategory());
       System.out.println(u1.getBalanse());
    }
}
