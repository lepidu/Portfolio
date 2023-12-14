/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bscca12020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Ken
 */
public class BScCA12020 {

    /**
     * Suggested solution to CA 1
     * 
     * NOTE  - this solution does NOT address the "distinction work" -- it just reads 1 item from the file and writes it to the new file
     * 
     * 
     */
    public static void main(String[] args) {
        
        String inputFilename = "people2.txt";     //assume file is located in same folder as project
        BufferedReader myFile;
        String personName = "", surname = "",status = "", title = ""; 
        int age = -1;    //initialise to an impossible value
        String gender = ""; //you could use char here if you wanted
        boolean valid = true;
        
        
        try {
            
            
            myFile = new BufferedReader(new FileReader(inputFilename));
            
        
        
            //the file is open
        
            
            
                personName = myFile.readLine(); //this should read the first line, which should  be the name
            
                age = Integer.parseInt(myFile.readLine()); //this shoudl read the next line, which should be the age. if it si not a number it will go to the catch
                
                gender = myFile.readLine(); //this shoudl be the 3rd line, which should be the gender
            
                       
            // There is *something* stored in all my variables, and age must be an int. Now I need to check to see if it is valid!
            if ( !(personName.matches("[a-zA-Z]+"))  && !(personName.contains(" "))){
                //the name is not only text and it does not contain at least 1 space, so it is invalid!
                System.out.println("The name data in the file " + inputFilename + " is invalid.  It must be in the format <firstname> <surname>. Only letters are allowed.");
                valid = false;
            }
            
            //note SEPARATE if statement used for age. This is because the age could be invalid sepafrately to the name, etc
            if ((age<0) || (age > 100)){
                
                System.out.println("The age data in the file " + inputFilename + " is invalid. Age is only allowed to be between 0 and 100");
                valid = false;
            }
            else if (age <= 18){
                status = "School";
            }
            else if (age <= 25){
                status = "College";
            }
            else if (age <= 66){
                status = "Worker";
            }
            else {
                //must be 67-100
                status = "Retired";
            }
            
            switch (gender.toUpperCase()){
                //it wasn't specified to check for upper or lower case, so this will convert the input to upper case any way
                //makes it easier to compare
                
                case "M":
                    title= "Mr";
                    break;
                case "F":
                    title = "Ms";
                    break;
                case "T":
                    title = "Mx";
                    break;
                default:
                    //not valid
                    System.out.println("The gender data in the file " + inputFilename + "  is invalid; Only M, F or T is allowed");
                    valid = false;
            }
            
            //valid will be false if ANY of the data is invalid
            
            if (valid){
                //only write to the file if the input is all valid
                
                writeToFile(title, personName, status);
            }
            
            
        
        } catch (Exception e){
            /*
               NOTE -- it would be possible to have different error messages based on different errors
            however we have not cover this in class, so I have kept it simple
            */
            
            System.out.println("The file " +  inputFilename + " is missing, or is not in the correct format. It should be:");
                System.out.println("Line 1 -- <firstname> <surname>");
                System.out.println("Line 2 -- <age>");
                System.out.println("Line 3 -- <gender -- only M, F or T allowed>");
        }
        
        
    }

    /**
     * Writes all the data to a file
     * @param title - Mr / Ms / Mx
     * @param surname
     * @param personName - original name
     * @param status  - persons current status as a string
     */
    private static void writeToFile(String title,  String personName, String status) {
       
        String outputFile = "status.txt";
        
        String surname = personName.substring(personName.indexOf(" "));  //surname is all text after the location of the space
        
        try {
                BufferedWriter myWriter = new BufferedWriter(new FileWriter(outputFile, true)); //will make a new file or append output to existing file
                
                //first, write the title, surname and firstletter of the name
                myWriter.write( title + " " + surname + ", " + personName.substring(0, 1));
                myWriter.newLine(); //goes to next line in file
                myWriter.write(status);
                myWriter.newLine();
            
                myWriter.close(); //save changes to the file
                
        } catch(Exception e){
            
            System.out.println("Unable to write to file " + outputFile + ". Please check that destination is not read-only");
        }
    }
    
}
