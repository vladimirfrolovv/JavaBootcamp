package ex01;

public class User {
    private final int identifier;
    private String name;
    private int balanse;

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

    public void setBalanse ( int balanse ) {
        if (balanse < 0 ) {
            System.err.println("Invalid Balance");
            System.exit(-1);
            this.balanse = 0;
        } else {
            this.balanse = balanse;
        }

    }
    User(String name, int balanse) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        setBalanse(balanse);
    }
}
