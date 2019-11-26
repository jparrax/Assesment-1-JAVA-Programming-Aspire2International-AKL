
//Before running the program you must to install Apache IPO located in Assignment1 Folder,
//You also have to refresh the location of the Excel Files that are in the same folder as well.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task2CreditLimit {
    
    //This is the information needed to give the outputs to the task
    String noAccount,allowCredits, exceeded;
    //Auxiliar matrix to work with the information
    String[][] matrix; 
    //Temporal register
    int i,j,k;
    //Permanent register
    int n,m,p;
    //Path to find the file
    private static final String FILE_PATH = "C:\\Users\\Aspire2 Student\\Desktop\\Graduated Diploma in IT\\Java Programming\\Junior\\Assesments\\Assesment 1\\Project\\Assignment1\\Task2.xlsx";
    //Array of objects to store clients who exceeded the limit
    Task2CreditLimit[] clientExceeded;
    
    Task2CreditLimit(){
        
    }
    
    //Set method to catch Number of Account of the client who have exceeded its limit
    void setNoAccount(String noAccount){
    
    this.noAccount = noAccount;
    
    }
    
    //Set method to catch Limit of the client who have exceeded its limit
    void setAllowCredits(String allowCredits){
    
    this.allowCredits = allowCredits;
    
    }
    
    //Set method to catch New Balance
    void setExceeded(String exceded){
    
        this.exceeded = exceded;
        
    }
    
    //Creating a container to catch all the information
    void createMatrix(){
        
         i = 0;
         j=0;
         m = 0;
         
        FileInputStream fis = null;

        try{
            
        //opening file
        fis =new FileInputStream(FILE_PATH);

        Workbook workbook = new XSSFWorkbook(fis);

        int numberOfSheets = workbook.getNumberOfSheets();

                //looping over each workbook sheet
                for (int k = 0; i < numberOfSheets; k++) {
                    Sheet sheet = workbook.getSheetAt(i);
                    Iterator rowIterator = sheet.iterator();

                    //iterating over each row
                    while (rowIterator.hasNext()) {

                        Row row = (Row) rowIterator.next();
                        Iterator cellIterator = row.cellIterator();

                        //iterating over each cell
                        while (cellIterator.hasNext()) {

                            Cell cell = (Cell) cellIterator.next();
                            j++;

                        }
                        
                        m = j;
                        j=0;
                        i++;
        
                    }

                }
                
                fis.close();
                
            }
            //In case of errors
             catch (FileNotFoundException e) {
                 
                e.getMessage();
                
            } 
             catch (IOException e) {
                 
                e.getMessage();
            }
      
     n = i;
     
     //Creating a new matrix with dimmension n*m+1(Including the column to save later the new balance)
     matrix = new String[n][m+1];
    
    }
    
    //Reading values from Excel
    void createValuestoMatrix(){
        
           i = 0;
           j=0;

        FileInputStream fis = null;

        try{
        //opening file
        fis =new FileInputStream(FILE_PATH);

        Workbook workbook = new XSSFWorkbook(fis);

        int numberOfSheets = workbook.getNumberOfSheets();

            //looping over each workbook sheet
            for (int k = 0; i < numberOfSheets; k++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();

                //iterating over each row
                while (rowIterator.hasNext()) {

                    Row row = (Row) rowIterator.next();
                    Iterator cellIterator = row.cellIterator();

                    //iterating over each cell and saving all the information in the matrix as a string
                    while (cellIterator.hasNext()) {

                        Cell cell = (Cell) cellIterator.next();

                        switch (cell.getCellType()){

                            case NUMERIC:

                            matrix[i][j] =  Double.toString(cell.getNumericCellValue());
                            break;

                            case STRING:

                            matrix[i][j] =  cell.getStringCellValue();
                            break;

                        }

                        j++;

                    }

                 j = 0;   
                 i++;

                }

            }

            fis.close();

        }

         catch (FileNotFoundException e) {

            e.getMessage();

        } 
         catch (IOException e) {

            e.getMessage();

        }

    }
    
    //Creating the a new column with the new balance
    void evaluateInMatrix(){
        
        i = 0;
    
        matrix[i][m] = "newBalance";
        
        for (i = 1 ; i < n; i++){
            
            matrix[i][m] = Double.toString(Double.parseDouble(matrix[i][1]) + Double.parseDouble(matrix[i][2]) - Double.parseDouble(matrix[i][3]));
            
        }
        
    }
    
    //Creating an array of objects
    void createClientExceeded(){
    
            k = 0; 
        
        for (i = 1; i < n; i++){
            
            if (Double.parseDouble(matrix[i][m]) < Double.parseDouble(matrix[i][4])){
                
                k++;
                
            }
            
        }
        
       p = k;
       clientExceeded = new Task2CreditLimit[p];
        
    }
    
    //Getting the number of clients who have exceeded its limit
    int getClientExceeded(){
    
        return p;
    
    }
    
    //Catching all the clients who have exceeded its limit
    void createValuetoClientExceeded(){

        k = 0;
        
        for (i = 1; i < n; i++){
            
            if (Double.parseDouble(matrix[i][m]) < Double.parseDouble(matrix[i][4])){
                
                clientExceeded[k] = new Task2CreditLimit();
                clientExceeded[k].setNoAccount(matrix[i][0]);
                clientExceeded[k].setAllowCredits(matrix[i][4]);
                clientExceeded[k].setExceeded(matrix[i][m]);
                k++;
                
            } 
            
        }
    
    }
    
    //Displaying the clients who have exceeded its limit
    void display(){
        
        for (k = 0; k < p; k++){
        
            System.out.println("The client with number of account " + clientExceeded[k].noAccount + " had a limit of " + clientExceeded[k].allowCredits + " and has a new balance of " + clientExceeded[k].exceeded + " (CREDIT LIMIT EXCEEDED).");
    
        }
        
    }
    
}
 
