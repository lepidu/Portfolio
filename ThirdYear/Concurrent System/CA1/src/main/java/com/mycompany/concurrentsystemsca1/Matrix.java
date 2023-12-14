package com.mycompany.concurrentsystemsca1;

import java.util.ArrayList;

/**
 *
 * @author leisly pino 2020303
 */
public class Matrix implements Runnable {

    //ArrayList to be multiplied
    private final ArrayList<Integer> numbers;
    //Store the result of matrix multiplication
    private final int[][] result = new int[10][10];

    public Matrix(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {

        int A[][] = new int[10][10]; //Store First Matrix
        int B[][] = new int[10][10]; //Store Second Matrix
        int count = 0;
        for (int row = 0; row < 10; row++) {
            //Loop to fill the first matrix
            for (int col = 0; col < 10; col++) {
                A[row][col] = numbers.get(count++);

                //Fill the first half of the numbers
                if (count == 100) {
                    break;
                }
            }
            //If the first half of the number are fill it, break to the loop
            if (count == 100) {
                break;
            }
        }
        count = 100; //Counter to start fill the second matrix 

        //Loop to fill the second matrix
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                B[row][col] = numbers.get(count++);

            }
        }

        //Matrix multiplication row x column
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Fill the result at the position (i,j)
                for (int k = 0; k < 10; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

    }

    public void multiplyMatrix() throws InterruptedException {

        //Create Thread
        Thread t = new Thread(this);
        //Start Thread
        t.start();
        //Wait to complete Thread
        t.join();

        //Print the result matrix
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%7d", result[i][j]);
            }
            System.out.println("");

        }
    }
}