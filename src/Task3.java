
public class Task3 {
    
    public static void main(String[] args){
    
        //Generate the necessary object 
        Task3Student student = new Task3Student();

        //Create and set values in a matrix after read it in Excel
        student.createArray();
        student.setValuesinArray();
        student.setValuestoTemporary();

        //Display menu and execute options
        student.displaymenu();
    
    }
    
}
