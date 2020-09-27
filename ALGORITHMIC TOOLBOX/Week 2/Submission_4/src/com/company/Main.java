package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

// Last Digit of the Sum of Fibonacci Numbers

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        long n = scanner.nextLong();
        System.out.println(SumLastDigit(n));
        //System.out.println(getFibonacciSumNaive(n));
    }

    public static long PisanoPeriod() {
        long previous = 0; // assigning the first value
        long current = 1; // assigning the second value
        long next = previous + current; // computing the next values of the series.

        // the repetition of m belong from 3 to m*m
        for (int i=0; i<100; i++) {
            next = (current + previous) % 10; // finding the next value in series
            previous = current; // moving the previous pointer to next value
            current = next; // moving the current pointer to next value
            if (previous==0 && current==1) {
                return i+1; // return when pattern is found
            }
        }
        return -1;
    }

    public static long SumLastDigit(long n) {
        n = n % PisanoPeriod();
        if (n <= 1) {
            return n;
        }
        int y = (int) n;
        long[] series = new long[y+1]; // array created  // O(n)
        series[0] = 0; // 1st value assigned           // O(1)
        series[1] = 1; // 2nd value assigned           // O(1)
        long lastDigit;
        long sum = series[0] + series[1];

        for (int i=2; i<y+1; i++) {                      // O(n)
            // successive values are added and stored
            series[i] = (series[i-1] + series[i-2]) % 10;     // O(n)
            lastDigit = series[i];
            sum += lastDigit;
        }
        //return Arrays.toString(series);                // O(1)
        //System.out.println(sum + "  :  " + series[y-1]);
        return sum%10;

        //take sum of all line and multiply the one in loop
        // O(n) + O(1) + O(1) + O(n)*O(n) + O(1) = O(n^2)
    }

    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }
        System.out.println(sum);
        return sum % 10;
    }
}
