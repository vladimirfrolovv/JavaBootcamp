package ex04;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction( Transaction tr);
    void deleteTransaction(UUID Id);
    Transaction[] transformListToArrayTr();
    int getSize();

}