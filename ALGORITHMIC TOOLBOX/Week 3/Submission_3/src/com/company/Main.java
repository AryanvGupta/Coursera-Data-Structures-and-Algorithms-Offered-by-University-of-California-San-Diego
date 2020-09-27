package com.company;

import java.util.Arrays;
import java.util.Scanner;

// Maximum Advertisement Revenue

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt(); // no. of input
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt(); // profit
        }

        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt(); // no. of clicks per day
        }
        System.out.println(maxDotProduct(a, b));
    }

    private static long maxDotProduct(long[] a, long[] b) {

        long result = 0;
        long[] sorted_a = sort(a);
        //System.out.println(Arrays.toString(sorted_a));
        long[] sorted_b = sort(b);
        //System.out.println(Arrays.toString(sorted_b));

        for (int i = 0; i < a.length; i++) {
            if (sorted_a[i] > 0 && sorted_b[i] > 0) {
                result += sorted_a[i] * sorted_b[i];
            }
            else if (sorted_a[i] < 0 && sorted_b[i] < 0) {
                result += sorted_a[i] * sorted_b[i];
            }
        }
        return result;
    }

    public static long[] sort(long[] array) {
        long[] tempArr;
        tempArr = array;
        boolean flag = true;
        long temp;
        // sorting logic
        while (flag) {
            flag = false;
            for (int i=0; i<tempArr.length-1; i++) {
                if (tempArr[i]<tempArr[i+1]) {
                    temp = tempArr[i];
                    tempArr[i] = tempArr[i+1];
                    tempArr[i+1] = temp;
                    flag = true;
                }
            }
        }
        return tempArr; // high to low
    }

}
