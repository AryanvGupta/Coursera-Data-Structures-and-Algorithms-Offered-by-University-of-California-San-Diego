package com.company;

import java.util.Scanner;

// GCDs (Greatest Common Divisor)

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        long a,b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        //System.out.println(NaiveGCD(a,b));
        System.out.println(EfficientGCD(a,b));
    }

    public static int NaiveGCD(long a, long b) {
        int greatest_no = 0;
        // d is a special divisor which allows to get the value of GCD(a,b)
        for (int d=1; d<(a+b); d++) {
            // when the below if condition satisfies we will get d
            // here d will be able to divide both a and b without leaving anr remainder
            if ((a%d == 0) && (b%d ==0)) {
                greatest_no = d;
            }
        }
        return greatest_no;
    }

    // Euclid's GCD algorithm
    // a' = a % b (a' is the remainder of a/b)
    // gcd(a,b) = gcd(a',b) = gcd(b,a')
    public static long EfficientGCD(long a, long b) {
        // test is any  one of them is zero the other is directly the GCD
        if (b == 0){
            return a;
        }
        else if (a == 0) {
            return b;
        }
        else {
            long rem = a % b;
            // use the below print line to see the method
            //System.out.println("gcd(" + b + ", " + rem + ")");
            return EfficientGCD(b,rem); // recursion until we get our ans
        }
    }
}
