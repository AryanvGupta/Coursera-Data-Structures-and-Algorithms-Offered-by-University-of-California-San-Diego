package com.company;

import java.util.Scanner;

// The goal in this code problem is to check whether an input sequence contains a majority element.

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(isMajority(a,n));
    }

    public static int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++)
        {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    private static int isMajority(int a[], int size)
    {
        int cand = findCandidate(a,size);
        int i, count = 0;
        for (i = 0; i < size; i++)
        {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return 1;
        else
            return 0;
    }

    // this method is slow
    private static int getMajorityElement(long[] a, int n) {
        for (int i=0;i<a.length-1;i++) {
            int count = 0 ;
            for (int j=0;j<a.length;j++) {
                if (a[i] == a[j]) {
                    //System.out.println(a[i] + " : " + a[j]);
                    count++;
                    //System.out.println(count);
                }
            }
            if (count > (n/2) ) {
                return 1;
            }
        }
        return 0;
    }

}
