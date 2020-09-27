package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int an = scanner.nextInt(); // length of first sequence
        int[] a = new int[an]; // values of first sequence
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }

        int bn = scanner.nextInt(); // length of second sequence
        int[] b = new int[bn]; // values of second sequence
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }

        int cn = scanner.nextInt(); // length of third sequence
        int[] c = new int[cn]; // values of third sequence
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }

        System.out.println(lcs3(a, b, c, an-1, bn-1, cn-1));
    }

    private static int lcs3(int[] a, int[] b, int[] c, int p, int q, int r) {

        if (p<=-1 || q<=-1 || r<=-1) {
            return 0;
        }
        else if (a[p] == b[q] && b[q] == c[r]) {
            return 1+lcs3(a,b,c,p-1,q-1,r-1);
        }
        else {
            return Math.max(lcs3(a,b,c,p-1,q,r),Math.max(lcs3(a,b,c,p,q-1,r),lcs3(a,b,c,p,q,r-1)));
        }
    }
}
