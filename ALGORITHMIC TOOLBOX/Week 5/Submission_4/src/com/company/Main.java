package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // length of first sequence
        int[] a = new int[n]; // values of first sequence
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt(); // length of second sequence
        int[] b = new int[m]; // values of second sequence
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        //System.out.println(naiveLCS2(a, b, n-1, m-1));
        System.out.println(efficientLCS2(a, b, n, m));

    }

    private static int efficientLCS2(int[] a, int[] b, int n, int m) {
        int[][] L = new int[n+1][m+1];

        for (int i=0;i<=n;i++) {
            //System.out.println("i : " + i);
            for (int j=0;j<=m;j++) {
                //System.out.println("j : " + j);
                if (i==0 || j==0) {
                    L[i][j] = 0;
                }
                else if (a[i-1] == b[j-1]) {
                    L[i][j] = L[i-1][j-1] + 1;
                }
                else {
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
                //System.out.println("L[i][j] : " + L[i][j]);
            }
        }
        return L[n][m];
    }

    private static int naiveLCS2(int[] a, int[] b, int n, int m) {

        if (n<=-1 || m<=-1) {
            return 0;
        }
        else if (a[n] == b[m]) {
            return 1+naiveLCS2(a,b,n-1,m-1);
        }
        else {
            return Math.max(naiveLCS2(a,b,n-1,m),naiveLCS2(a,b,n,m-1));
        }

//        for (int i=0;i<n;i++) {
//            System.out.println("i : " + i);
//            for (int j=i;j<m;j++) {
//                System.out.println("j : " + j);
//                if (a[i] == b[j]) {
//                    System.out.println("a[i] : " + a[i] + " - " + "b[j] : " + b[j]);
//                    count++;
//                    System.out.println("count : " + count);
//                }
//            }
//        }
//        return count;
    }
}
