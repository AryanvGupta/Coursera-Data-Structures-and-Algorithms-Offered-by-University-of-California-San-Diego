package com.company;

import java.util.Scanner;

// The goal in this problem is to find the minimum number of coins needed
// to change the input value (an integer) into coins with denominations 1, 5, and 10.

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }

    public static int getChange(int m) {
        int coins = 0;
        int c;

        while (m > 0) {
            if (m >= 10) {
                c = m / 10;
                coins += c;
                m = m % 10;
            }
            if (m >= 5) {
                c = m / 5;
                coins += c;
                m = m % 5;
            }
            if (m >= 1) {
                c = m / 1;
                coins += c;
                m = m % 1 ;
            }
        }
        return coins;
    }
}
