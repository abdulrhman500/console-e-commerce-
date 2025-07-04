package exceptions;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(double balance, double required) {
        super("Insufficient balance. Current balance: " + balance + ", required: " + required);
    }
}
