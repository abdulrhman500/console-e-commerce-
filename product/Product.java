package product;

import java.util.*;

public class Product {
    float price;
    String name;
    int availableQuantity;

    HashMap<String, Trait> traits = new HashMap<>();

    public Product(float price, String name, int availableQuantity, List<Trait> traits) {

        this.price = price;
        this.name = name;
        this.availableQuantity = availableQuantity;
        for (Trait trait : traits) {
            if (trait != null)
                this.traits.put(trait.getClass().getSimpleName(), trait);
        }

        this.validateInstance(this);
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public String updateName(String newName) {

        this.validateName(newName);
        this.name = newName;
        return this.name;

    }

    public float updatePrice(float newPrice) {

        this.validatePrice(newPrice);
        this.price = newPrice;
        return this.price;
    }

    public int increaseQuantityBy(int raiseValue) {

        if (raiseValue < 0)
            throw new IllegalArgumentException("raise value can not be negative");
        if (availableQuantity + raiseValue < 0)
            throw new IllegalArgumentException("incresing this quantitty by this value will cause overflow");

        this.availableQuantity += raiseValue;
        return this.availableQuantity;

    }

    public int decreaseQuantityBy(int decreaseValue) {
        if (decreaseValue < 0)
            throw new IllegalArgumentException("decrease value cannot be negative");

        if (this.availableQuantity - decreaseValue < 0) {
            throw new IllegalArgumentException("can not decrease quantity by passed value " + decreaseValue);
        }

        this.availableQuantity -= decreaseValue;

        return this.availableQuantity;

    }

    public boolean isShipable() {
        return traits.containsKey(ShippableProductTrait.class.getSimpleName());
    }

    public boolean hasExpireyDate() {
        return traits.containsKey(ExpirableProductTrait.class.getSimpleName());
    }

    /// validation

    public void validateInstance(Product instance) {

        validatePrice(this.price);

        validateName(this.name);

        validateAvailableQuantity(this.availableQuantity);

    }

    private void validatePrice(float price) {

        if (!(price > 0.0 && price <= Float.MAX_VALUE)) {
            throw new IllegalArgumentException("price can not be " + price);
        }

    }

    private void validateName(String name) {

        if (!(name.length() >= 2)) {
            throw new IllegalArgumentException("name must be at least 2 characters long");
        }
    }

    private void validateAvailableQuantity(int quantity) {

        if (!(quantity >= 0)) {
            throw new IllegalArgumentException("available quantity cannot be negative");
        }
    }

}