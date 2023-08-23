package ex05;

public class BadBalanceExeption extends RuntimeException{
    public BadBalanceExeption(String message) {
        super(message);
    }
}
