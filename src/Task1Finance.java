
import java.text.DecimalFormat;
import java.util.Scanner;

//This is the object that we are going to use to performe all the requirements

public class Task1Finance {
    
    //Variables needed
    double amount, rate, savings = 0, months, a;
   
    //Object to give decimal format
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    
    //Default constructor
    Task1Finance(){
    }
    
     //Set method to Input the amount of saved monthly
     void setAmount(Scanner inputScanner){
        
        System.out.println("Input amount: ");
        
        //Validate if the input is a double
        if (inputScanner.hasNextDouble()){
            
            //Set amount
            amount = inputScanner.nextDouble();} 
        
        else{
            
            //Recall set to input the value again
            System.out.println("Amount must be a number.");
            inputScanner.next();
            setAmount(inputScanner);
            
        }
            
    }
     
     //Get method to return the amount of money saved monthly
     double getAmount(){
     
     return amount;
     
     }

     //Set method to Input the interest rate
     void setRate(Scanner inputScanner){
        
        System.out.println("Input interest rate: ");
       
         //Validate if the input is a double
        if (inputScanner.hasNextDouble()){
         
            //Set interest rate
            rate = inputScanner.nextDouble();
            
        }
        
        else{
            
            //Recall set to input the value again
            System.out.println("Interest rate must be a number.");
            inputScanner.next();
            setRate(inputScanner);
            
        }
        
    }
     
     //Get method to return the interest rate
     double getRate(){
     
     return rate;
         
     } 
     
     //Set method to Input the number of months
     void setMonths(Scanner inputScanner){
         
        System.out.println("Input months: ");
        
        //Validate if the input is double and no negative
        if (inputScanner.hasNextDouble()){
            
            months = Math.abs(inputScanner.nextDouble());
            
        }
        
        else{
        
            //Recall set to input month
            System.out.println("Month must be a number.");
            inputScanner.next();
            setMonths(inputScanner);
            
        }
        
     }
     
     //Get method to return the months
     double getMonths(){
     
         return months;
     
     }
     
     //Get method to return the savings
     Double getSavings(){
         
         //Restarting the acumulator
         savings = 0;
         
         //Computing total savings
        for(int i = 1; i <= months; i++){

            savings = (savings + amount)*(1 + rate/(100*12));
            
        }

        return savings;
        
     }
     
     //Show the savings by month
     void displaySavingsByMonths(){
         
         // Restarting the acumulator
         savings = 0; 
         //Printing header
         System.out.println("\n"+ "Month  " + "Amount");
         
         //Computing and printing month by month
         for(int i = 1; i <= months; i++){

            savings = (savings + amount)*(1 + rate/(100*12));
            System.out.println("  " + i + "  " + "  " + numberFormat.format(savings) + "  ");
            
        }
     
     }
    
}
