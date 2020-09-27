package com.company;

import java.util.Arrays;
import java.util.Scanner;

// Last Digit of the Sum of Fibonacci Numbers Again
// starting from m to n

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long start = scanner.nextLong();
        long end = scanner.nextLong();

        //System.out.println(getFibonacciPartialSumNaive(start, end));
        System.out.println(getFibonacciPartialSumEfficient(start,end));

    }

    private static long getFibonacciPartialSumNaive(long start, long end) {
        long sum = 0;
        long current = 0;
        long next  = 1;

        for (long i = 0; i <= end; ++i) {
            if (i >= start) {
                sum += current;
            }
            long new_current = next;
            next = next + current;
            current = new_current;
        }
        return sum % 10;
    }

    private static long getFibonacciPartialSumEfficient(long start, long end) {
        start = start % PisanoPeriod();
        end = end % PisanoPeriod();
        if (end <= 1) {
            return end;
        }
        int x = (int) start;
        int y = (int) end;
        long[] series = new long[y+1]; // array created  // O(n)
        series[0] = 0; // 1st value assigned           // O(1)
        series[1] = 1; // 2nd value assigned           // O(1)
        long lastDigit;
        long sum;

        if (start <= 1) {
            sum = 1;
            for (int i=2; i<y+1; i++) {                      // O(n)
                // successive values are added and stored
                series[i] = (series[i-1] + series[i-2]) % 10;     // O(n)
                lastDigit = series[i];
                if (i>=start) {
                    sum += lastDigit;
                }
            }
        }
        else {
            sum = 0;
            for (int i=2; i<y+1; i++) {                      // O(n)
                // successive values are added and stored
                series[i] = (series[i-1] + series[i-2]) % 10;     // O(n)
                lastDigit = series[i];
                if (i>=start) {
                    sum += lastDigit;
                }
            }
        }
        //System.out.println(Arrays.toString(series)); // O(1)
        //System.out.println(sum + "  :  " + series[y-1]);
        return sum%10;
    }

    public static long PisanoPeriod() {
        long previous = 0; // assigning the first value
        long current = 1; // assigning the second value
        long next; // computing the next values of the series.

        // the repetition of m belong from 3 to m*m
        // here m = 100
        for (int i=0; i<10000; i++) {
            next = (current + previous) % 100; // finding the next value in series
            previous = current; // moving the previous pointer to next value
            current = next; // moving the current pointer to next value
            if (previous==0 && current==1) {
                return i+1; // return when pattern is found
            }
        }
        return -1;
    }
}
