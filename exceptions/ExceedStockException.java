package exceptions;

public class ExceedStockException extends Exception {
	
    public ExceedStockException(String productName, int currentStock, int neededQuantity){
        super("No enough quantity available for product " + productName + " available stock: " + currentStock + "needed quantity: "+ neededQuantity);
    }
}
