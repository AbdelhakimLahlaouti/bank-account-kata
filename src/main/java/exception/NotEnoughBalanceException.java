package exception;

public class NotEnoughBalanceException extends RuntimeException {
    public NotEnoughBalanceException() {
        super("Error during withdraw operation : account doesn't have enough balance ");
    }
}
