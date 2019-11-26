
//Before running the program you must to install Apache IPO located in Assignment1 Folder,
//You also have to refresh the location of the Excel Files that are in the same folder as well.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Task3Student {
    
    //Object Atributes
    String name, grade;
    Double mark1, mark2, mark3, average;
    
    //Permanent registers to fix the lenght of the arrays
    int m,n;
    
    //Location of the file
    private static final String FILE_PATH = "C:\\Users\\Aspire2 Student\\Desktop\\Graduated Diploma in IT\\Java Programming\\Junior\\Assesments\\Assesment 1\\Project\\Assignment1\\Task3.xlsx";
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    
    //Array of headers
    String[] headers;
    
    //Object arrays
    Task3Student[] student;
    Task3Student[] temporary;
    Task3Student[] temporaryRegister = new Task3Student[1];
    
    
    //Constructor
    Task3Student(){
    
    }
    
    // Setters and Getters
    void setName(String name){
    
        this.name = name;
    
    }
    
    String getName(){ 
        
        return name;
        
    }
    
    void setMark1(double mark1){
        
        this.mark1 = mark1;
        
    }
    
    double getMark1(){
    
        return mark1;
    
    }
    
    void setMark2(double mark2){
    
        this.mark2 = mark2;
    
    }
    
    double getMark2(){
        
        return mark2;
        
    }
    
    void setMark3(double mark3){
    
        this.mark3 = mark3;
    
    }
    
    double getMark3(){
        
        return mark3;
        
    }
    
    void setAverage(){
    
        average = (mark1 + mark2 + mark3)/3;
       
    }
    
   double getAverage(){
   
       return average;
   
   } 
    
    void setGrade(){
    
        if (average < 60){
        
            grade = "F";
            
        } else if(average < 70){
        
            grade = "D";
                    
        } else if(average < 80){

            grade = "C";
            
        } else if(average < 90){

            grade = "B";
                
        } else{

        grade = "A";

        }
        
    }
    
    String getGrade(){
        
        return grade;
        
    }
    
    //Lenght of the arrays
    void createArray(){
        
        int i = 0, j = 0;

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
                        
                        n = j;
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
      
     m = i - 1;
     
     //Creating a new matrix with dimmension n*m+1(Including the column to save later the new balance)
     student = new Task3Student[m];
     temporary = new Task3Student[m];
     headers = new String[n + 2];
    
    }
    
    //Setting value of the arrays
    void setValuesinArray(){
    
        int i = 0, j = 0;

        FileInputStream fis = null;

        try{
            //opening file
        fis =new FileInputStream(FILE_PATH);

        Workbook workbook = new XSSFWorkbook(fis);
        
        int numberOfSheets = workbook.getNumberOfSheets();

        //looping over each workbook sheet
        for (int k = 0; i < numberOfSheets; k++) {
            Sheet sheet = workbook.getSheetAt(k);
            Iterator rowIterator = sheet.iterator();

            //iterating over each row
            while (rowIterator.hasNext()) {

                Row row = (Row) rowIterator.next();
                Iterator cellIterator = row.cellIterator();


                if (i != 0){

                    student[i-1] = new Task3Student();

                }

                //iterating over each cell
                while (cellIterator.hasNext()) {

                    Cell cell = (Cell) cellIterator.next();
                    //Set information
                    if (i == 0){

                            headers[j] = cell.getStringCellValue();

                    }  else {

                        if (cell.getColumnIndex() == 0){
                            student[i-1].setName(cell.getStringCellValue());
                        }else if(cell.getColumnIndex() == 1){
                            student[i-1].setMark1(cell.getNumericCellValue());
                        } else if(cell.getColumnIndex() == 2){
                            student[i-1].setMark2(cell.getNumericCellValue());
                        } else if(cell.getColumnIndex() == 3) {
                            student[i-1].setMark3(cell.getNumericCellValue());
                        }

                    }

                    j++;

                } 

                if (i != 0 ){
                
                //Compute average and grades
                student[i - 1].setAverage();
                student[i - 1].setGrade();

                }

                j = 0;
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
        
        headers[4] = "Average";
        headers[5] = "Grade";
        
        //Display info
        System.out.printf("%-15s%8s%6s%n", headers[0], headers[4], headers[5]);
        
        for (Task3Student student1 : student) {
            
        System.out.printf("%-15s%8s%6s%n",student1.getName() ,numberFormat.format(student1.getAverage()), student1.getGrade());
        
        }
        
    }
    
    //set values to the temporary array
    void setValuestoTemporary(){
        
        int i = 0;
    
        for (Task3Student student1 : student){

            
            temporary[i] = new Task3Student();
            temporary[i].setName(student1.getName());
            temporary[i].setMark1(student1.getMark1());
            temporary[i].setMark2(student1.getMark2());
            temporary[i].setMark3(student1.getMark3());
            temporary[i].setAverage();
            temporary[i].setGrade();
            i++;

        }
       
    }
    
    //Printing original array
    void displayList(){
    
        System.out.printf("%-15s%15s%15s%15s%15s%15s%n", headers[0], headers[1], headers[2], headers[3], headers[4], headers[5]);
        
        for (Task3Student student1 : student) {
            
        System.out.printf("%-15s%15s%15s%15s%15s%15s%n",student1.getName() ,numberFormat.format(student1.getMark1()),numberFormat.format(student1.getMark2()),numberFormat.format(student1.getMark3()) ,numberFormat.format(student1.getAverage()), student1.getGrade());
        
        }
        
    }
    
    //Printing temporary
    void displayTemporary(){
        
        System.out.printf("%-15s%15s%15s%15s%15s%15s%n", headers[0], headers[1], headers[2], headers[3], headers[4], headers[5]);
        
        for (Task3Student temporary1 : temporary) {
      
              System.out.printf("%-15s%15s%15s%15s%15s%15s%n",temporary1.getName() ,numberFormat.format(temporary1.getMark1()),numberFormat.format(temporary1.getMark2()),numberFormat.format(temporary1.getMark3()) ,numberFormat.format(temporary1.getAverage()), temporary1.getGrade());
        
        }
    
    }
    
    //Selection sort algorithm
    void selectionSort(){
    
        int smaller;
        //Iterating from the beggining
        for (int i = 0; i < m; i++){
            smaller = i;
            //Comparison
            for (int j = i + 1; j < m; j++){
                if (temporary[j].getName().compareTo(temporary[smaller].getName()) < 0){
                    smaller = j;
                }
            } 
            
            if (smaller != i){
                //Swaping
                temporaryRegister[0] = temporary[i];
                temporary[i] = temporary[smaller];
                temporary[smaller] = temporaryRegister[0];
            
            }
            
        }
        
    }
    
    //Insertion sort algorithm
    void insertionSort(){
    
        //Setting first
        for (int i = 1; i < m; i++){
            //Spliting and comparing
            for(int j = i; j > 0; j--){
                if(temporary[j].getAverage() < temporary[j-1].getAverage()){

                    temporaryRegister[0] = temporary[j];
                    temporary[j] = temporary[j -1];
                    temporary[j-1] = temporaryRegister[0];

                }

            }

        }
    
    }
    
    //Insertion search algorithm
    void binarySearch(){
        
        int low = 0;
        int high = m-1;
        int index = 99;
        System.out.println("Input an average: ");
        Scanner inputScanner = new Scanner(System.in);
        int key = inputScanner.nextInt();
        
        insertionSort();
        
        while(low <= high){
            
            //Dividing
            int mid = (low + high)/2;
            
            //Reducing vector
            if ( (int) temporary[mid].getAverage() < key){

            low = mid + 1;

            }

            else if((int) temporary[mid].getAverage() > key){

                high = mid - 1;

            }
            
            //Setting
            else if((int) temporary[mid].getAverage() == key){

                index = mid;
                break;

            }
            
        }
        
        if (index != 99){
            
        System.out.println("The student with an average of " + key + " is " + temporary[index].getName() + ".");
        
        } else {
        
            System.out.println("There is not student with this average");
            
        }
        
    }
    
    //Sequential search algorithm 
    void sequentialSearch(){
        
        int i;
        double min =  temporary[0].getAverage();
        int index = 0;
        
        //iterating from the beginning
        for ( i = 0 ; i < m; i++ ){

            if ( temporary[i].getAverage() < min){

                min = temporary[i].getAverage();
                index = i; 

            }
            
        }

        System.out.println("The student whit the minimum average is " + temporary[index].getName() + " with an average of " + numberFormat.format(temporary[index].getAverage()) + ".");
        
    }
    
    //Creating distribution
    void createDistribution(){
        
        int A = 0, B = 0, C = 0, D = 0, F = 0;
    
        for (Task3Student i: temporary){
        
            switch(i.getGrade()){
                case "A":
                    A++;
                    break;
                case "B":
                    B++;
                    break;
                case "C":
                    C++;
                    break;
                case "D":
                    D++;
                    break;
                case "F":
                    F++;
                    break;
            }
            
        }
        
        System.out.println("Grade distribution: A = " + A + " B = " + B + " C = " + C + " D = " + D + " F = " + F +".");
        
    }
    
    // Display menu and order execution
    void displaymenu(){
        
        Scanner inputScanner;
        int a = 99;
        
        //Menu and Redisplaying
        while( a != 0){
            
            System.out.println("1: Print the entire list\n" +
                               "2: Sort and print the list alphabetically\n" +
                               "3: Sort and print the list in descending order based on the average.\n" +
                               "4: Ask the user to enter an average and search for the student who has that average\n" +
                               "5: Find the student who has the minimum average\n" +
                               "6: Print the grade distribution\n" +
                               "0: Exit\n" +
                               "Enter your choice? ");

            inputScanner = new Scanner(System.in);
            a = inputScanner.nextInt();

            //Executing options of the menu
            switch (a){

                case 1:
                    displayList();
                    break;
                case 2:
                    selectionSort();
                    displayTemporary();
                    break;
                case 3:
                    insertionSort();
                    displayTemporary();
                    break;
                case 4:
                    binarySearch();
                    break;
                case 5:
                    sequentialSearch();
                    break;
                case 6:
                    createDistribution();
                    break;

            }

        } 

        System.out.println("This is the end of the program…Thank you");
    
    }
        
}
    
    
    
