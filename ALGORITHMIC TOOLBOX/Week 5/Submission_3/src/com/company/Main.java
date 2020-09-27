package com.company;

import java.util.Scanner;

// The goal of this problem is to implement the algorithm for computing
// the edit distance between two strings.

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

    public static int EditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];

        for (int i=0;i<=m;i++) {
            for (int j=0;j<=n;j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    //System.out.println("dp[i][j] : " + dp[i][j]);
                }
                else if (j == 0) {
                    dp[i][j] = i;
                    //System.out.println("dp[i][j] : " + dp[i][j]);
                }
                else if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                    //System.out.println("dp[i][j] : " + dp[i][j]);
                }
                else {
                    dp[i][j] = 1 + min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
                    //System.out.println("dp[i][j] : " + dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private static int min(int x, int y, int z) {
        if (x<=y && x<=z) {
            return x;
        }
        else if (y<=z && y<=x) {
            return y;
        }
        else {
            return z;
        }
    }
}
