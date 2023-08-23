package ex05;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Transaction head;
    private Transaction tail;
    private int size = 0;
    @Override
    public void addTransaction ( Transaction tr) {
        if (head == null) {
            head = tr;
        } else if (tail == null) {
            tail = head;
            tail.setPrev(tr);
            tr.setNext(tail);
            head = tr;
        } else {
            tr.setNext(head);
            head.setPrev(tr);
            head = tr;
        }
        size++;
    }
    @Override
    public void deleteTransaction( UUID Id) throws TransactionNotFoundException {
        if (size == 0 || Id == null) {
            throw new TransactionNotFoundException("Zero Transactions");
        }
        if (Id.equals(head.getIdentifier())) {
            if (size == 1) {

            } else {
                head = head.getNext();
            }

        } else if (Id.equals(tail.getIdentifier())) {
            if (size == 1) {
                head = null;
            } else {
                tail = tail.getPrev();
            }
        } else {
            boolean flag = false;
            Transaction tmp = head;
            while (tmp.getNext() != null) {
                if (Id.equals(tmp.getIdentifier())) {
                    flag = true;
                    break;
                }
                tmp = tmp.getNext();
            }
            if (!flag) {
                throw new TransactionNotFoundException("Id Not Found");
            }
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
        }
        size--;
    }
    @Override
    public Transaction[] transformListToArrayTr() {
        Transaction[] res = new Transaction[size];
        int i = 0;
        Transaction tmp = head;
        while (i < size) {
            res[i] = tmp;
            tmp = tmp.getNext();
            i++;
        }
        return res;
    }
    @Override
    public int getSize ( ) {
        return size;
    }

}