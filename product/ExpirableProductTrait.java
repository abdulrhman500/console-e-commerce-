package product;
import java.time.LocalDate;

public class ExpirableProductTrait implements ITrait{

    private final LocalDate expiryDate;


    public ExpirableProductTrait(LocalDate expiryDate) {
        validateExpiryDate(expiryDate);
       this.expiryDate = expiryDate;
 }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
    
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public void validate() {
    
        validateExpiryDate(this.expiryDate);
    }

    private void validateExpiryDate(LocalDate dateToValidate) {
        if (dateToValidate == null) {
            throw new IllegalArgumentException("Expiry date cannot be null");
        }
        if (dateToValidate.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Product can not be expired");
        }
    }
}