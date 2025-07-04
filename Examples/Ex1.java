package Examples;

import java.time.LocalDate;

import cart.Cart;
import customer.Customer;
import exceptions.EmptyCartException;
import exceptions.ExceedStockException;
import payment.PaymentService;
import product.Product;
import product.ProductBuilder;

public class Ex1 {

    public static void run(){

        Product cheese = new ProductBuilder()
                .withExpirableProductTrait(LocalDate.now().plusDays(5))
                .withShippableProductTrait(200)
                .build(100, "Cheese", 10);
        Product biscuits = new ProductBuilder()
                .withExpirableProductTrait(LocalDate.now().plusDays(10))
                .withShippableProductTrait(700)
                .build(150, "Biscuits", 5);
        Product tv = new ProductBuilder()
                .withShippableProductTrait(5000)
                .build(3000, "TV", 3);
        Product scratchCard = new ProductBuilder()
                .build(50, "Scratch Card", 100);

      
        Customer customer = new Customer("CA", 1000);
        Cart cart = customer.getCart();
        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);

            PaymentService.checkout(customer, cart);

        } catch (ExceedStockException e) {
            System.out.println(e.getMessage());
        } catch (EmptyCartException e) {
            System.out.println(e.getMessage());
        }

    }
}
