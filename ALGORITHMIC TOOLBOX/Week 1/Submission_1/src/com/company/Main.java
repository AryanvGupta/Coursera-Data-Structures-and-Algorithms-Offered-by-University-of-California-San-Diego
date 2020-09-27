package com.company;

import java.util.Scanner;

// sum of two nos.
class Main {

    // method that returns the answer
    static int sumOfDigits(int first_digit, int second_digit) {
        return first_digit + second_digit;
    }

    // main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt(); // input value 1
        int b = s.nextInt(); // input value 2

        System.out.println(sumOfDigits(a, b)); // print result
    }
}