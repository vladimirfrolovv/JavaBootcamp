package ex04;

import java.util.UUID;
public class Transaction {
    enum TransferCategory {
        DEBITS,
        CREDITS
    }
    private UUID identifier = UUID.randomUUID();
    private User recipient;
    private User sender;
    private Transaction.TransferCategory category;
    private int transfer_amount;

    private Transaction next = null;

    public Transaction getPrev ( ) {
        return prev;
    }

    public void setPrev ( Transaction prev ) {
        this.prev = prev;
    }

    private Transaction prev = null;
    public void setNext ( Transaction next ) {
        this.next = next;
    }
    public Transaction getNext ( ) {
        return next;
    }
    public UUID getIdentifier ( ) {
        return identifier;
    }

    public void setIdentifier ( UUID identifier ) {
        this.identifier = identifier;
    }

    public User getRecipient ( ) {
        return recipient;
    }

    public void setRecipient ( User recipient ) {
        this.recipient = recipient;
    }

    public User getSender ( ) {
        return sender;
    }

    public void setSender ( User sender ) {
        this.sender = sender;
    }

    public Transaction.TransferCategory getCategory ( ) {
        return category;
    }

    public void setCategory ( Transaction.TransferCategory category ) {
        this.category = category;
    }

    public int getTransfer_amount ( ) {
        return transfer_amount;
    }

    public void setTransfer_amount ( int transfer_amount ) {
        this.transfer_amount = transfer_amount;
    }
    Transaction( User recipient, User sender, int transfer_amount , Transaction.TransferCategory category) {
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        if (category == Transaction.TransferCategory.CREDITS && transfer_amount < 0) {
            this.transfer_amount = transfer_amount;
        } else if (category == Transaction.TransferCategory.DEBITS && transfer_amount > 0) {
            this.transfer_amount = transfer_amount;
        } else {
            System.err.println("Invalid Transfer amount");
            System.exit(-1);
        }


    }
}