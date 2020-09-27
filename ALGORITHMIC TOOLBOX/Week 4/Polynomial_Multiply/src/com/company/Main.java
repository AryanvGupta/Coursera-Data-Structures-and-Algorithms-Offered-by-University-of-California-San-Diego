package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long n = scanner.nextLong(); // no. of inputs
        long[] A = new long[(int) n]; // array with co-efficients of first polynomial
        for (int i=0; i<n; i++) {
            A[i] = scanner.nextLong();
        }
        long[] B = new long[(int) n]; // array with co-efficients of second polynomial
        for (int i=0; i<n; i++) {
            B[i] = scanner.nextLong();
        }

        long[] C = NaiveMultiPoly(A,B,n);
        System.out.println(Arrays.toString(C));
    }

    // Efficient Solution using divide and conquer
    private static void efficientCD() {
        
    }

    // Better Solution using divide and conquer
    private static long NaiveCD(long[] A, long[] B,long n, int a, int b) {
        int x = (int) (n*2) - 1;
        long[] C = new long[x];

        if (n == 1) {
            C[0] = A[a] * B[b];
            return C;
        }
        for (int i=0;i<n;i++) {
            C[i] = NaiveCD(A,B,n/2,a,b);
        }
    }

    // Basic Solution
    private static long[] NaiveMultiPoly(long[] A, long[] B,long n) {
        int x = (int) (n*2) - 1;
        long[] C = new long[x];

        for (int i=0; i<x-1; i++) {
            C[i] = 0;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                C[i+j] += (A[i] * B[j]);
//                System.out.println("i : " + i);
//                System.out.println("j : " + j);
//                System.out.println("C[i+j] : " + C[i+j]);
            }
        }
        return C;
    }
}
