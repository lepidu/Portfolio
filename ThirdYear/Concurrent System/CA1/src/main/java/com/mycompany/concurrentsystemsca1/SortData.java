package com.mycompany.concurrentsystemsca1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author leisly pino 2020303
 */
public class SortData {

    //ArrayList to be sorted
    private ArrayList<Integer> numbers;
    private Thread t;

    //Constructor
    public SortData(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    //Sort data from largest to smallest
    public void sort() {
        
        //Sort ArrayList in descending order
        Collections.sort(numbers, Collections.reverseOrder());
        
        //Create Array to stored the result
        int mSort[][] = new int[20][10];
        int sRow = 0;
        int sCol = 0;
        
        //Stored data row by row
        for (int i = 0; i < numbers.size(); i++) {
            mSort[sRow][sCol] = numbers.get(i);
            sCol++;
            if (sCol == 10) {
                sCol = 0;
                sRow++;
            }
        }
        
        //Print the sorted data
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%5d", mSort[i][j]);

            }
            System.out.println();

        }

    }
    
    //Start Thread if no exist
    public void start(){
        if (t == null){
            t = new Thread(new Runnable() {
                @Override
                public void run() {
                     sort();
                }
            });
            t.start();
        }
    }
    
    //Waits for the thread completed before returning
    public void join() throws InterruptedException {
        if (t != null){
            t.join();
        }
    }
}