package ex05;

public class User {
    private final int identifier;
    private String name;
    private int balanse;
    private TransactionsLinkedList user_transaction = new TransactionsLinkedList();

    public TransactionsLinkedList getUser_transaction ( ) {
        return user_transaction;
    }

    public int getIdentifier ( ) {
        return this.identifier;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getBalanse ( ) {
        return balanse;
    }

    public void setBalanse ( int balanse ) throws BadBalanceExeption {
        if (balanse < 0 ) {
           throw new BadBalanceExeption("Bad Balance");
        } else {
            this.balanse = balanse;
        }

    }
    User(String name, int balanse) {
        setBalanse(balanse);
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;

    }
}
