package cart;

import product.Product;
import exceptions.*;
import shipping.IshipableItem;
import product.ShippableProductTrait;

public class CartItem implements IshipableItem {

    Product product;
    int quantity;

    public CartItem(Product product, int quantity) throws ExceedStockException {
        if (product.getAvailableQuantity() - quantity < 0) {
            throw new ExceedStockException(product.getName(), product.getAvailableQuantity(), quantity);
        }
        this.product = product;
        this.quantity = quantity;
    }

    public void decreaseQuantityBy(int decreaseValue) {

        if (decreaseValue > quantity) {
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

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getWeight() {
        if (product.isShipable()) {
            ShippableProductTrait trait = (ShippableProductTrait) product.getTraits().get(ShippableProductTrait.class.getSimpleName());
            if (trait != null) {
                return trait.getWeight() * quantity; //TODO
            }
        }
        return 0;
    }
}
