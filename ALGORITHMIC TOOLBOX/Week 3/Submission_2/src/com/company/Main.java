package com.company;

import java.util.Arrays;
import java.util.Scanner;

// The goal of this code problem is to implement an algorithm
// for the fractional knapsack (bag) problem.

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt(); // no. of items
        int capacity = scanner.nextInt(); // capacity of bag/knapsack
        int[] values = new int[n]; // value of n items
        int[] weights = new int[n]; // weight of n items
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        double ans = getOptimalValue(capacity, values, weights);
        System.out.println(ans);
    }

    private static double getOptimalValue(double capacity, int[] values, int[] weights) {
        double value = 0;
        int index = 0;
        int n = values.length;
        double[] itemPUnit = new double[n];
        double[] itemsTaken = new double[n];
        double a;

        int[] temp_values = new int[n];
        int[] temp_weights = new int[n];

        for (int i=0; i<n+1; i++) {
            System.out.println("i : " + i);
            if (capacity == 0) {
                return value;
            }

            temp_values = values;
            temp_weights = weights;

            System.out.println("values : " + Arrays.toString(values));
            System.out.println("weights" + Arrays.toString(weights));

            System.out.println("temp_values : " + Arrays.toString(temp_values));
            System.out.println("temp_weights : " + Arrays.toString(temp_weights));

            index = Max(temp_values,temp_weights) - 1;
            System.out.println("index : " + index);

            if (weights[index] > 0) {

                a = Math.min(temp_weights[index],capacity);
                System.out.println("a : " + a);

                value += a*temp_values[index]/temp_weights[index];
                System.out.println("value : " + value);

                temp_weights[index] = (int) (temp_weights[index] - a);
                System.out.println("weights[index] : " + temp_weights[index]);

                capacity = capacity - a;
                System.out.println("capacity : " + capacity);
            }
            //index = max(values,weights);
        }
        return value;
    }

    private static int max(int[] values, int[] weights) {
        int n = values.length;
        int index = -1;
        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                System.out.println("x : " + x + " y : " + y);
                if (weights[x] > 0 && weights[y] > 0) {
                    double p = values[x]/weights[x];
                    double q = values[y]/weights[y];
                    if (p>q) {
                        index = x;
                    }
                    else {
                        index = y;
                    }
                }
            }
        }
        return index;
    }

    private static int Max(int[] values, int[] weights) {
        double value = 0;
        int i;
        int n = values.length;
        double[] itemPUnit = new double[n];

        for (int j=0; j<n; j++) {
            if (weights[j] > 0) {
                itemPUnit[j] = values[j]/weights[j];
            }
        }

        for (i=0; i<values.length; i++) {
            if (itemPUnit[i] > value) {
                value = itemPUnit[i];
                itemPUnit[i] = 0;
            }
        }
        return i;
    }
}
