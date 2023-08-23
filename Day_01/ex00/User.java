package ex00;

public class User {
    private int identifier;
    private String name;
    private int balanse;

    public void setIdentifier ( int identifier ) {
        this.identifier = identifier;
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

    public void setBalanse ( int balanse ) {
        if (balanse < 0 ) {
            System.err.println("Invalid Balance");
            System.exit(-1);
            this.balanse = 0;
        } else {
            this.balanse = balanse;
        }

    }
    User(int identifier, String name, int balanse) {
            this.identifier = identifier;
            this.name = name;
            setBalanse(balanse);
    }
}
