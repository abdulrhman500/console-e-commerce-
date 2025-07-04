package cart;

import product.Product;
import exceptions.*;

public class CartItem {

    Product product;
    int quantity;

    public CartItem(Product product, int quantity) throws ExceedStockException {
        if (product.getAvailableQuantity() - quantity < 0) {
            throw new ExceedStockException(product.getName(), product.getAvailableQuantity(), quantity);
        }
    }

    public void decreaseQuantityBy(int decreaseValue) {

        if (quantity - decreaseValue > 0) {
            throw new IllegalArgumentException("Decrease value is greater than current quantity.");
        }

        quantity -= decreaseValue;
    }
     public void increaseQuantityBy(int increaseValue) throws ExceedStockException {

        if (product.getAvailableQuantity() - (quantity + increaseValue) < 0) {
            throw new ExceedStockException(this.product.getName(), this.product.getAvailableQuantity(), quantity+increaseValue);
        }

        quantity += increaseValue;
    }

     public Product getProduct() {
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }

}
