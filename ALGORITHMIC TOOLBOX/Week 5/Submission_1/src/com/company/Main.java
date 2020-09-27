package com.company;

import java.util.Scanner;

// The minimum number of coins with denominations 1, 3, 4 that changes money.

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt(); // amount money
        int[] coins = new int[]{1,3,4}; // coins with denomination 1,3,4
        System.out.println(getChange(money,coins));
    }

    // Dynamic solution
    private static int getChange(int money, int[] coins) {
        int[] MinNumCoins = new int[money+1];
        MinNumCoins[0] = 0;
        for (int m=1; m<=money; m++) {
            //System.out.println("m : " + m);
            //System.out.println("MinNumCoins[m] : " + MinNumCoins[m]);
            MinNumCoins[m] = money;
            for (int i=0; i<coins.length; i++) {
                //System.out.println("i : " + i);
                if (m >= coins[i]) {
                    int NumCoins = MinNumCoins[m-coins[i]] + 1;
                    //System.out.println("NumCoins : " + NumCoins + " MinNum Coins[m] : " + MinNumCoins[m]);
                    if (NumCoins < MinNumCoins[m]) {
                        MinNumCoins[m] = NumCoins;
                        //System.out.println("MinNumCoins[m] : " + MinNumCoins[m]);
                    }
                }
            }
        }
        return MinNumCoins[money];
    }

    // slow method
    private static int getChange_recursive(int money, int[] coin) {
        if (money == 0) {
            return 0;
        }

        int MinNumCoins = Integer.MAX_VALUE;

        for (int i=0; i<coin.length; i++) { // 1st denomination
            if (money >= coin[i]) { // condition
                int NumCoins = getChange_recursive(money-coin[i],coin);
                if (NumCoins+1 < MinNumCoins) {
                    MinNumCoins = NumCoins + 1;
                }
            }
        }
        return MinNumCoins;
    }

    // in accurate
    private static int getChange_greedy(int money) {
        int change = 0;
//
//        while (money > 0) {
//            coin <- largest denomination
//                    that does not exceed 'money'
//
//            change += coin;
//
//            money = money - coin;
//        }
        return change;
    }
}
