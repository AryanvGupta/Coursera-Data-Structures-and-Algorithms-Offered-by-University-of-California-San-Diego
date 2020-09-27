package com.company;

import java.util.Arrays;
import java.util.Scanner;

// Finding the last digit of the nth number in fibonacci series

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.println(LastDigit(n));
    }

    public static long LastDigit(long n) {
        if (n <= 1) {
            return n;
        }

        long[] series = new long[(int) (n+1)];

        // Pre-computing units digit of
        // first n Fibonacci numbers
        Fibonacci(series);
        int index = (int) (n % series.length);

        return series[index]; // Returns last digit of n'th Fibonacci Number
    }

    public static void Fibonacci(long[] series) {

        series[0] = 0; // 1st value assigned
        series[1] = 1; // 2nd value assigned

        // Add the previous 2 numbers
        // in the series and store
        // last digit of result
        for (int i=2; i<series.length; i++) {
            series[i] = (series[i-1] + series[i-2]) % 10;
        }
    }
}
