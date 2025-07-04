public class BasicProduct{

    float price;
    String name;
    int availableQuantity;


    public BasicProduct(float price, String name, String availableQuantity){
        
        this.price = price;
        this.name = name;
        this.availableQuantity = availableQuantity;
         
        this.validateInstance(this);
    }


    public String updateName(String newName){
        
        this.validateName(newName);
        this.name = newName;
        return this.name;

    }
    public float updatePrice(float newPrice){

        this.validatePrice(newPrice);     
        this.price = newPrice;
        return this.price;
    }
   public int increaseQuantityBy(int raiseValue){

        if(raiseValue<0)
            throw new Exception("Raise value can not be negative");
       if(availableQuantity + raiseValue <0)
            throw new Exception("Incresing this quantitty by this value will cause overflow");
        
        this.availableQuantity +=raiseValue;
        return this.availableQuantity;

   }    

    public int decreaseQuantityBy(int decreaseValue){
        if(decreaseValue<0)
            return false;

        
        if(this.availableQuantity - decreaseValue<0){
            throw new Exeption("Can not decrese quantity by pass value"+decreaseValue);
        }

        this.availableQuantity -=decreaseValue;

        return this.availableQuantity;

   }    

    public void validateInstance(BasicProduct instance){

        validatePrice(this.price);  

        validateName(this.name);
           
        validateAvailableQuantity(this.availableQuantity);        

    }
    
    private void validatePrice(float price){
         
         if(!(price > 0.0 && price<=Float.MAX_VALUE)){
            throw Exception("price can not be"+price);
         }         
    
    }
    
    private void validateName(String name){

        if(!(name.length >=2)){
            throw new Exception("");
        }
    }

    private void validateAvailableQuantity(int quantity){

         if(!(quantity>=0)){
            throw new Exception("");
         }
    }
    
}