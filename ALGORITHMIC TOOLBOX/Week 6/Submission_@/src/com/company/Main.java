package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // no. of countries
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt(); // no. of souvenirs from i country
        }

        if (partition3(A,n)) {
            System.out.println("1");
        }
        else System.out.println("0");


//        if (findPartition(A, n)) {
//            System.out.println("1");
//        }
//        else System.out.println("0");
    }

    // Dynamic solution O(sum*n)
    private static boolean partition3(int[] A, int n) {
        int sum = 0;
        int i,j;

        for (i=0; i<n; i++) {
            sum += A[i];
        }

        if (sum%3 != 0) {
            return false;
        }

        boolean[][] part = new boolean[(sum/3)+1][n+1];

        for (i=0;i<=n;i++) {
            part[0][i] = true;
        }

        for (i=1;i<=sum/3;i++) {
            part[i][0] = false;
        }

        for (i=1;i<=sum/3;i++) {
            for (j=1;j<=n;j++) {
                part[i][j] = part[i][j-1];
                if (i >= A[j-1]) {
                    part[i][j] = part[i][j] || part[i-A[j-1]][j-1];
                }
            }
        }
        return part[sum/3][n];
    }

    // Greedy solution O(2^n)
    private static boolean isSubsetSum (int[] arr, int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (arr[n-1] > sum)
            return isSubsetSum (arr, n-1, sum);

        /* else, check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
        return isSubsetSum (arr, n-1, sum) ||
                isSubsetSum (arr, n-1, sum-arr[n-1]);
    }

    // Returns true if arr[] can be partitioned in two
    // subsets of equal sum, otherwise false
    private static boolean findPartition (int[] arr, int n)
    {
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum%3 != 0)
            return false;

        // Find if there is subset with sum equal to half
        // of total sum
        return isSubsetSum (arr, n, sum/3);
    }
}
