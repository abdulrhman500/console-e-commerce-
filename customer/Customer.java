package customer;
import cart.Cart;
import exceptions.InsufficientBalanceException;

public class Customer {

    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.name = name;
        this.balance = balance;
        this.cart = new Cart(); 
    }

    public String getName() { 
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("deposit amount must be positive.");
        }
        this.balance += amount;
        System.out.println(this.name + " deposited " + amount + ". New balance: " + this.balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException { 
        if (amount <= 0) {
            throw new IllegalArgumentException("withdrawal amount must be positive.");
        }
        if (this.balance < amount) {
            throw new InsufficientBalanceException(this.balance, amount);
        }
        this.balance -= amount;
        System.out.println(this.name + " withdrew " + amount + ". New balance: " + this.balance);
    }
}