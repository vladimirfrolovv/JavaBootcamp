package ex05;

import java.util.UUID;

public interface TransactionsList {
    public void addTransaction( Transaction tr);
    public void deleteTransaction(UUID Id);
    public Transaction[] transformListToArrayTr();
    int getSize();

}
