package com.company;

import java.util.Scanner;

// Given two integers 𝑛 and 𝑚, find the output for 𝐹𝑛 mod 𝑚

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        long n = scanner.nextLong(); // variable for series length
        long m = scanner.nextLong(); // variable for divisor

        System.out.println(fibonacciMod(n,m));
    }

    // this is the method used to convert the fibonacci series into the series of Fi mod m
    // it reduces the max value of the fibonacci series
    // and finds a pattern/period which repeats itself after a no. of computations
    public static long PisanoPeriod(long m) {
        long previous = 0; // assigning the first value
        long current = 1; // assigning the second value
        long next = previous + current; // computing the next values of the series.

        // the repetition of m belong from 3 to m*m
        for (int i=0; i<(m*m); i++) {
            next = (current + previous) % m; // finding the next value in series
            previous = current; // moving the previous pointer to next value
            current = next; // moving the current pointer to next value
            if (previous==0 && current==1) {
                return i+1; // return when pattern is found
            }
        }
        return -1;
    }

    public static long fibonacciMod(long n, long m) {

        n = n % PisanoPeriod(m); // reducing the value of n

        if (n <= 1) {
            return n;
        }
        long previous = 0;
        long current = 1;
        long x = n; // index/value for the series Fi mod m

        // computation for finding Fn mod m
        for (int i=1; i<n; i++) {
            x = (current + previous) % m; // finding the next value in series
            previous = current; // moving the previous pointer to next value
            current = x; // moving the current pointer to next value
        }
        return x % m; // returning the final ans
    }
}
