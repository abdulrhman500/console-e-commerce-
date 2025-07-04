package exceptions;

public class EmptyCartException extends Exception {
    public EmptyCartException(String customerName){
        super(customerName+ "cart is empty");
    }
}
