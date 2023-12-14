package com.mycompany.concurrentsystemsca1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CA 1
 *
 * @author leisly pino 2020303
 */
public class ConcurrentSystemsCA1 {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        String line;
        String data[] = null;
        int num;
        ArrayList<Integer> numbers = new ArrayList<>();

        try {

            //Read file data.csv
            Scanner br = new Scanner(new FileReader("data.csv"));

            //Loop reads each line of the file
            while (br.hasNext()) {
                line = br.nextLine();
                data = line.split(",");

                //Loop saves each number of the line
                for (int i = 0; i < data.length; i++) {
                    num = Integer.parseInt(data[i].trim());
                    //Add the numbers in the ArrayList
                    numbers.add(num);
                }
            }

            //Deviation Standard
            StandardDeviation deviation = new StandardDeviation(numbers);
            //Start Deviation Standard Thread
            deviation.start();
            //Waiting for Thread finish
            deviation.join();
            //Sleep for 2 seconds the Thread
            Thread.sleep(4000);
            double devTotal = deviation.getDeviation();
            System.out.println("The standard deviation is: " + devTotal);
            System.out.println();

            // Print Matrix Multiplication
            System.out.println("The matrix multiplication: ");
            Matrix mult = new Matrix(numbers);
            //Sleep for 2 seconds the Thread
            Thread.sleep(4000);
            mult.multiplyMatrix();
            System.out.println();

            // Sort data
            SortData sort = new SortData(numbers);
            System.out.println("The sort data: ");
            //Sleep for 2 seconds the Thread
            Thread.sleep(4000);
            sort.start();
            sort.join();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}