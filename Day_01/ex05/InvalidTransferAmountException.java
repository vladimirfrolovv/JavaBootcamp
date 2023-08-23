package ex05;

public class InvalidTransferAmountException extends RuntimeException {
    public InvalidTransferAmountException(String message) {
        super(message);
    }
}
