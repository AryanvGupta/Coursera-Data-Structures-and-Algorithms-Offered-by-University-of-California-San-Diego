package com.company;

import java.util.Arrays;
import java.util.Scanner;

// Fibonacci series

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long n = scanner.nextLong();
        scanner.nextLine();

        //System.out.println(NaiveFibonacci(n));
        System.out.println(EfficientFibonacci(n));
    }

    public static long NaiveFibonacci(long n) {
        if (n <= 1) {
            return n;
        }

        long sum = 0, n1, n2;
        // recursion to find (n-1)th and (n-2)th no.
        n1 = NaiveFibonacci(n-1);
        n2 = NaiveFibonacci(n-2);
        sum = n1 + n2;

        // use the below print line to see the method and calculation for Fibonacci series
        //System.out.println(n1 + " + " + n2 + " = " + sum);
        return sum;
    }

    public static long EfficientFibonacci(long n) {
        if (n <= 1) {
            return n;
        }
        long[] series = new long[(int) (n+1)]; // array created  // O(n)
        series[0] = 0; // 1st value assigned           // O(1)
        series[1] = 1; // 2nd value assigned           // O(1)
        for (int i=2; i<n+1; i++) {                      // O(n)
            // successive values are added and stored
            series[i] = series[i-1] + series[i-2];     // O(n)
        }
        //return Arrays.toString(series);                // O(1)
        return series[(int) n];

        //take sum of all line and multiply the one in loop
        // O(n) + O(1) + O(1) + O(n)*O(n) + O(1) = O(n^2)

    }
}
