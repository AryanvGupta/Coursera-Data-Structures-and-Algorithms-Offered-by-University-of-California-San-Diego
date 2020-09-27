package com.company;

import java.util.Arrays;
import java.util.Scanner;

// Last Digit of the Sum of Squares of Fibonacci Numbers

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long n = scanner.nextLong();

        // long s = getFibonacciSumSquaresNaive(n);
        long r = getFibonacciSumSquaresEfficient(n);

        System.out.println(r);
    }

    private static long getFibonacciSumSquaresEfficient(long n) {
        n = n % PisanoPeriod();
        int p = (int) n+1;
        long[] series = new long[p+1];
        series[0] = 0;
        series[1] = 1;
        long lastDigit;
        long sum = 1;

        for (int i=2; i<p+1; i++) {
            series[i] = (series[i-1] + series[i-2]) % 10;
            lastDigit = series[i];
            sum += lastDigit;
        }
        //System.out.println(Arrays.toString(series));
        sum = (series[(int) n]) * (series[(int) (n+1)]);
        return sum%10;
    }

    public static long PisanoPeriod() {
        long previous = 0; // assigning the first value
        long current = 1; // assigning the second value
        long next; // computing the next values of the series.

        // the repetition of m belong from 3 to m*m
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            next = (current + previous) % 10; // finding the next value in series
            previous = current; // moving the previous pointer to next value
            current = next; // moving the current pointer to next value
            if (previous==0 && current==1) {
                return i+1; // return when pattern is found
            }
        }
        return -1;
    }

    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }
}
