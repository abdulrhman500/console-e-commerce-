package utils;
import cart.Cart;
import cart.CartItem;
import customer.Customer;
import exceptions.InsufficientBalanceException;


public class PrinterUtil {
     public static void printCheckoutReceipt(Customer customer, Cart cart, double subtotal, double shipping) throws InsufficientBalanceException {
    System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
               System.out.printf("%dx %s\n", item.getQuantity(), item.getProduct().getName());
            System.out.println(" " + (int)(item.getQuantity() * item.getProduct().getPrice()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\n " + (int)subtotal);
        System.out.println("Shipping\n " + (int)shipping);
        System.out.println("Amount\n " + (int)(subtotal + shipping));
        System.out.println("END.");
    }
}
