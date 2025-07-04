package payment;
import java.util.ArrayList;
import java.util.List;

import cart.Cart;
import cart.CartItem;
import customer.Customer;
import exceptions.EmptyCartException;
import exceptions.ExceedStockException;
import exceptions.InsufficientBalanceException;
import exceptions.ProductExpiredException;
import product.ExpirableProductTrait;
import product.Product;
import shipping.IshipableItem;
import shipping.ShippingService;
import utils.PrinterUtil;

public class PaymentService {

    private static final double SHIPPING_FEE_PER_ITEM = 15.0;

    public static void checkout(Customer customer, Cart cart) throws EmptyCartException {

        if (cart.isEmpty()) {
            throw new EmptyCartException(customer.getName());
        }

        double subtotalPrice = 0;
        double shippingPrice = 0;
        List<IshipableItem> shippableItems = new ArrayList<>();
        try {
            for (CartItem item : cart.getItems()) {
                Product p = item.getProduct();

                checkExpiry(p);
                checkStock(item, p);

                subtotalPrice += item.getQuantity() * p.getPrice();

                if (p.isShipable()) {
                    shippableItems.add(item);
                    shippingPrice += SHIPPING_FEE_PER_ITEM;
                }
            }

        } catch (ProductExpiredException e) {
            System.out.println("Error: Product expired - " + e.getMessage());
            return;
        } catch (ExceedStockException e) {
            System.out.println("Error: Exceeded stock for product - " + e.getMessage());
            return;
        }
        try {
            if (customer.getBalance() < subtotalPrice + shippingPrice) {
                throw new InsufficientBalanceException(subtotalPrice, shippingPrice);
            }

            ShippingService.shipItems(shippableItems);
           
            PrinterUtil.printCheckoutReceipt(customer, cart, subtotalPrice, shippingPrice);
       
       
       
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: Insufficient balance for checkout " + e.getMessage());
        }
    }

    private static void checkExpiry(Product p) throws ProductExpiredException {

        if (p.hasExpireyDate()) {
            ExpirableProductTrait exp = (ExpirableProductTrait) p.getTraits()
                    .get(ExpirableProductTrait.class.getSimpleName());
            if (exp != null && exp.isExpired()) {
                throw new ProductExpiredException(p.getName());
            }
        }
    }

    private static void checkStock(CartItem item, Product p) throws ExceedStockException {
        if (item.getQuantity() > p.getAvailableQuantity()) {
            throw new ExceedStockException(item.getProduct().getName(), 0, 0);
        }

    }

}
