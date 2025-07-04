package product;
public class ShippableProductTrait implements ITrait{
    private double weight;

    public ShippableProductTrait(double weight) {
        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }

    @Override
    public void validate() {
       validateWeight(this.weight);
    }

    private void validateWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Product Weight must be greater than 0");
        }
    }
}