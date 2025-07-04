package exceptions;

public class ProductExpiredException extends Exception {
    public ProductExpiredException(String productName) {
        super("Product '" + productName + "' is expired.");
    }
}
