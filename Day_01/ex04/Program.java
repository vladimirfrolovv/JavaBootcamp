package ex04;

public class Program {
    public static void main(String[] args) {
        User u1 = new User("John", 2500);
        User u2 = new User("Bob", 1500);
       TransactionsService service = new TransactionsService();
       service.addUser(u1);
       service.addUser(u2);
       service.performTransaction(1,2,500);
       System.out.println(service.getUserBalance(1));
       System.out.println(service.getUserBalance(2));
       Transaction[] res = u1.getUser_transaction().transformListToArrayTr();
       service.deleteUserTransaction(1,res[0].getIdentifier());
       System.out.println(u1.getUser_transaction().getSize());
        Transaction t1 = new Transaction(u1, u2, 1000, Transaction.TransferCategory.DEBITS);
        Transaction t2 = new Transaction(u1, u2, 1000, Transaction.TransferCategory.DEBITS);
        u1.getUser_transaction().addTransaction(t1);
        u2.getUser_transaction().addTransaction(t2);
       Transaction[] array = service.arrayNotPairedTransactions();
       System.out.println(array.length);

    }

}
