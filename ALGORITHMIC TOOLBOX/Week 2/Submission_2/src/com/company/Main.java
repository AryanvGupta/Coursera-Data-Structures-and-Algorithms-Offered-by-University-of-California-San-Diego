package com.company;

// LCM (Least Common Multiple)

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long a,b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        long GCD = EfficientGCD(a,b);
        System.out.println(LCM(GCD,a,b));
    }

    public static long LCM(long GCD, long a, long b){
        return a*b/GCD;
    }

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
