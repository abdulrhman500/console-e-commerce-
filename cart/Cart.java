package cart;

import product.*;
import java.util.*;
import exceptions.*;

public class Cart {
    List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity) throws ExceedStockException {

        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().equals(product)) {

                item.increaseQuantityBy(quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public void remove(Product product) {
        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().equals(product)) {
                iterator.remove();
                return;
            }

        }
    }

    public void remove(CartItem item) {
        items.remove(item);
    }

    public void clear() {
        this.items.clear();
    }
}
