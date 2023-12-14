package com.mycompany.concurrentsystemsca1;

import java.util.ArrayList;

/**
 *
 * @author leisly pino 2020303
 */
public class StandardDeviation extends Thread {

    private ArrayList<Integer> numbers;
    private double deviation;

    //Constructor
    public StandardDeviation(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    //Run Thread
    public void run() {
        double mean;
        double variance = 0;
        double sum = 0;
        int n = numbers.size();

        //Calculate Mean
        for (int i : numbers) {
            sum = sum + i;
        }
        mean = sum / n;

        //Calculate Variance
        double total;
        for (int i = 0; i < n; i++) {
            total = Math.pow(numbers.get(i) - mean, 2);
            variance += total;
        }

        variance = variance / (n - 1);

        //Calculate Standard Deviation
        deviation = Math.sqrt(variance);
    }

    //Return the calculated Standard Deviation
    public double getDeviation() {

        return deviation;
    }

}