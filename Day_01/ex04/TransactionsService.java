package ex04;

import java.util.UUID;

public class TransactionsService {
    private UsersList usersList = new UsersArrayList();

    public void addUser(User user) {
        usersList.addUser(user);
    }
    public int getUserBalance(int id_user) {
        return usersList.getUserById(id_user).getBalanse();
    }
    public void performTransaction( int id_recipient, int id_sender, int sum_tran) {
        User recipient = usersList.getUserById(id_recipient);
        User sender = usersList.getUserById(id_sender);
        if (id_recipient == id_sender || sender.getBalanse() < sum_tran || sum_tran < 0) {
            throw new IllegalTransactionException("Invaild transaction");
        }
        Transaction deb = new Transaction(recipient, sender, sum_tran, Transaction.TransferCategory.DEBITS);
        Transaction cred = new Transaction(recipient, sender, -sum_tran, Transaction.TransferCategory.CREDITS);
        cred.setIdentifier(deb.getIdentifier());
        recipient.getUser_transaction().addTransaction(deb);
        sender.getUser_transaction().addTransaction(cred);
        recipient.setBalanse(recipient.getBalanse() + sum_tran);
        sender.setBalanse(sender.getBalanse() - sum_tran);
    }
    public Transaction[] getTransfers(int id_user) {
       return usersList.getUserByIdx(id_user).getUser_transaction().transformListToArrayTr();

    }
    public void deleteUserTransaction(int id_user, UUID id_transaction) {
        usersList.getUserById(id_user).getUser_transaction().deleteTransaction(id_transaction);
    }
    public Transaction[] arrayNotPairedTransactions() {
        TransactionsLinkedList all_transactions = getAllTransaction();
        Transaction[] ar_all_transactions = all_transactions.transformListToArrayTr();
        TransactionsLinkedList list_not_paired_tran = new TransactionsLinkedList();
        int counter = 0;
        for ( int i = 0; i < all_transactions.getSize(); ++i) {
            UUID id_transaction = ar_all_transactions[i].getIdentifier();
            counter = 0;
            for ( int j = 0; j < all_transactions.getSize(); ++j) {
                if (id_transaction.equals(ar_all_transactions[j].getIdentifier())) {
                    counter++;
                }
            }
            if (counter != 2) {
                Transaction tmp = ar_all_transactions[i];
                list_not_paired_tran.addTransaction(tmp);
            }
        }
        return list_not_paired_tran.transformListToArrayTr();

    }
    private TransactionsLinkedList getAllTransaction() {
        TransactionsLinkedList all_transactions  = new TransactionsLinkedList();
        for (int i = 0; i < usersList.getAmountUsers(); ++i ) {
            Transaction[] array_users_transactions = usersList.getUserByIdx(i).getUser_transaction().transformListToArrayTr();
            for (int  j = 0; j < usersList.getUserByIdx(i).getUser_transaction().getSize(); ++j) {
                Transaction tmp = array_users_transactions[j];
                all_transactions.addTransaction(tmp);
            }

        }
        return all_transactions;
    }
}
