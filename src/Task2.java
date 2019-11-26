
public class Task2 {
    
    public static void main(String[] args) {
      
        //Casting the object that we have created
      Task2CreditLimit creditLimit = new Task2CreditLimit();
      
        //Applying the methods 
      creditLimit.createMatrix();
      creditLimit.createValuestoMatrix();
      creditLimit.evaluateInMatrix();
      creditLimit.createClientExceeded();
      
        //Giving the output to the user
      if (creditLimit.getClientExceeded() != 0){
        
          creditLimit.createValuetoClientExceeded();
          creditLimit.display();
        
      } 
      
      else {
          
          System.out.println("There is not any client with exceeded account");
                
      }
      
    }
    
}
