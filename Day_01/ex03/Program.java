package ex03;
public class Program {
    public static void main(String[] args) {
        User u1 = new User("John", 2500);
        User u2 = new User("Bob", 1500);
        Transaction t1 = new Transaction(u1, u2,-500, Transaction.TransferCategory.CREDITS);
        Transaction t2 = new Transaction(u1, u2,500, Transaction.TransferCategory.DEBITS);
        Transaction t3 = new Transaction(u1, u2,-1000, Transaction.TransferCategory.CREDITS);
        u1.getUser_transaction().addTransaction(t1);
        u1.getUser_transaction().addTransaction(t2);
        u1.getUser_transaction().addTransaction(t3);
        u1.getUser_transaction().deleteTransaction(t2.getIdentifier());
        Transaction[] res = new Transaction[2];
        res = u1.getUser_transaction().transformListToArrayTr();
        for (int i = 0; i < u1.getUser_transaction().getSize(); ++i) {
            System.out.println(res[i].getTransfer_amount());
        }

    }

}
