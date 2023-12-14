package homework4c;
import java.util.Scanner;
/**Homework 4
 * Create a program that will ask the user their age. 
 * @author Leisly Pino 2020303
 */
public class Homework4C {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int age = 0;
        try{
        Scanner myKB = new Scanner(System.in);
        // Ask user to enter their age
        System.out.println("How old are you? ");
        age = myKB.nextInt();
        
        // We verify the data entry
        
        if (age > 0 && age < 18 ) // If you are under 18 years old
            System.out.println("Too young to vote ");
        
        else if (age>=18 && age<66) // Check if it is within the range 18 to 65 years
            System.out.println("Working hard? ");
        
        else if (age>=66 && age<100) // Check if you are over 66 years old
            System.out.println("Enjoy Retirement! ");
        
        else // If it is 0, a negative number or greater than 100 years
            System.out.println("It is an invalid number ");
        }
        catch (Exception e){
            // If user enters another character that is not a number
             System.out.println("That is not a number ");
        }
        
    }
    

}