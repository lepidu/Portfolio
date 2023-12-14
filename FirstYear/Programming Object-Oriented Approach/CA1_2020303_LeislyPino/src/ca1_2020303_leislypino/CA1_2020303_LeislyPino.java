/** CONTINUOUS ASSESSMENT 1
 *  BSc.(Hons) in Computing in IT – 1st Year
 *  Programming: Object-Oriented Approach
 *  Lecturer: Ken Healy
 *  File Access & String Manipulation
 *  Student: Leisly Pino Duran 
 *  Student No: 2020303
 */

package ca1_2020303_leislypino;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/** 
 * We will read the lines of an existing People.txt file,
 * we will validate the data and then 
 * create our output file Status.txt
 * @author Leisly Pino
 */
public class CA1_2020303_LeislyPino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    // We start with the main variables that we will use in our code
    
        String myFileName = "People.txt"; // Existing file in our folder, where we will read the data
        String filename = "Status.txt"; // Will be the file that we are going to create for the data output
        String fullName; 
        String age;
        String gender; 
        String title; // Based on gander
        
        try {
        
            // Will work to write the output to a file
            // true = append to the file or false = overwrite the file
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(filename, false)); 

            // Will read our file
            Scanner myFile = new Scanner(new FileReader(myFileName)); 
       
        
            if (myFile.hasNext()){ // If we have something in our file
                
                myWriter.write("List: "); // We start writing in the output file
                myWriter.newLine(); // Line break
                
                // Loop that will process all the data in the file 
                // The process ends until the data in the file is finished
                while (myFile.hasNextLine()){ 
                               
                    fullName=myFile.nextLine(); // Read the first line of the file
                    age= myFile.nextLine(); // Read the second line of the file
                    gender =myFile.nextLine(); // Read the third line of the file
                     
                    
                    // Validate the gender input of is M, F or T in uppercase or lowercase
                    if ("M".equals(gender) || "m".equals(gender) ||"F".equals(gender) ||"f".equals(gender) ||"T".equals(gender) || "t".equals(gender)){
                        
                        gender = gender.toUpperCase(); // Convert to Uppercase
                    
                        switch(gender) {
                        // Start the search for the gender to add a corresponding title
                        
                            case "M":                    
                                title="Mr. ";
                                break;
                            case "F":
                                title ="Ms. ";
                                break;
                            case "T":
                                title= "Mx. ";
                                break;
                            default:
                                title= "Invalidate data";
                                
                        } // End switch
                    
                        myWriter.write(title); // Write the title in our output file
                        
                    } // End if gender
                    
                    else {
                    //If it is a value other than M, F or T, either uppercase or lowercase
                    
                        myWriter.write("It is an invalid gender "); 
                        myWriter.newLine(); 
                    
                    } // End else of if gender
                    
                    
                    // Validate fullName input of letters between A-Z in uppercase or lowercase and space
                    if (fullName.matches("[a-zA-Z ]*")){ 
                        
                        // Surname array, where we use split which divides String fullName 
                        // from space, consider the first space it reads
                        String [] surname = fullName.split(" "); 
                        
                        // The split function writes the data after the space by the value 1, 
                        // with value 0 it writes data before the space. 
                        // The charAt function gives us the letter indicating the position, 
                        // in our case it is 0, since we want the initial of the name.
                        myWriter.write(surname[1] + ", "+fullName.charAt(0)+ "."); 
                        myWriter.newLine();
                    
                    } // End if fullName
                    
                    else{ 
                        //Contains different characters than letters
                        myWriter.write("The name have diferrent characteres ");
                        myWriter.newLine(); 
                    }
                    
                    if (age.matches("[0-9]*")){ // Confirm that the data entry is a number
                   
                        // Pass our data age from String to int with the function Integer.parseInt
                        int status = Integer.parseInt(age);
                        
                        // Start to analyze the age range to determine a status              
                        if (status > 0 && status <= 18 ){ // If you are under 18 years old
                            myWriter.write("School");
                            myWriter.newLine(); 
                        }
                        else if (status>18 && status<=25) {// Check if it is within the range 19 to 25 years
                            myWriter.write("College");
                            myWriter.newLine();         
                        }
                        else if (status>=26 && status<=66){ // Check if it is within the range 26 to 66 year
                            myWriter.write("Worker");
                            myWriter.newLine();         
                        }
                        else if (status>=67 && status<=100){ // Check if it is within 67 to 100 years old  
                            myWriter.write("Retired");
                            myWriter.newLine(); 
                        }
                        else { // If it is greater than 100 or a negative number  
                            myWriter.write("It is an invalid number");
                            myWriter.newLine(); 
                        }
                    } // End if age
        
                    else{ 
                        // It is a different character than number
                        myWriter.write("It is an invalid number ");
                        myWriter.newLine(); 
                    }
          
        
                } // End While      
                
                myWriter.close(); // Close the output file
           
            } // End if - Data found
        
            else {
                // So if our file is empty, will write it to the output file
                myWriter.write("The file " + myFileName + " is empty!"); 
                myWriter.close(); // Close the output file
            }
               
        } // End try
        
        catch (Exception e){
            
            // If you can't find our existing file
            System.out.println("Error - unable to find file " ); 
        } // End catch
    }  
}