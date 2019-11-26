
import java.text.DecimalFormat;
import java.util.Scanner;

public class Task1 {
    
    public static void main(String[] args){
        
        //New objects in our program
        Scanner inputScanner = new Scanner(System.in);
        Task1Finance finance = new Task1Finance();
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        //Getting the Inputs
        finance.setAmount(inputScanner);
        finance.setRate(inputScanner);
        finance.setMonths(inputScanner);
        
        //Giving the Output to the user
        //By months
        finance.displaySavingsByMonths();
        
        //Total result
        System.out.println("\n" + "you have saved monhly " + finance.getAmount() + ", The interest rate was " + finance.getRate() + "% during " + finance.getMonths() + " months and you actually have in your account " + numberFormat.format(finance.getSavings()));
        
    }
    
}
