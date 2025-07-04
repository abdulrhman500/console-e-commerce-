    package product;

    import java.time.LocalDate;
    import java.util.ArrayList;

    public class ProductBuilder {
        private ArrayList<ITrait> traits;

        public ProductBuilder(){
            this.traits = new ArrayList<>();
        }

        public ProductBuilder withExpirableProductTrait(LocalDate expiryDate) {
            this.traits.add(new ExpirableProductTrait(expiryDate));
            return this;
        }

        public ProductBuilder withShippableProductTrait(double weight) {

            this.traits.add((new ShippableProductTrait(weight)));
            return this;
        }

        public Product build(float price, String name, int availableQuantit){
            
            return new Product(price, name, availableQuantit, this.traits);
        }
    }
