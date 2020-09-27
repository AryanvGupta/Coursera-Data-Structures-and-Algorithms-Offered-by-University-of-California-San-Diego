package com.company;

import java.util.Arrays;
import java.util.Scanner;

// Car Re-fill
// A = X0 < X1 < X2 < X3 <.....< Xn < Xn+1= B
// A = source ; Xn = Refill point ; B = Destination

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int B = scanner.nextInt(); // Final destination
        int L = scanner.nextInt(); // distance covered in 1 full tank
        int n = scanner.nextInt(); // no. of refill points

        int[] stops = new int[n+2]; // array to store positions of refill points
        for (int i = 1; i <= n; i++) {
            stops[i] = scanner.nextInt(); // refill points position
        }

        System.out.println(MinRefills(B,L,stops));
    }

    // O(n)
    public static int MinRefills(int B, int L, int[] X) {

        int n = X.length - 1;
        X[0] = 0; // Source point
        X[n] = B; // Destination
        //System.out.println(Arrays.toString(X)); // check the values in array
        int numRefills = 0; // no. of refills made
        int currentRefill = 0; // the current position of car

        while (currentRefill < n) {
            //System.out.println("currentRefill : " + currentRefill); // check the current position of car
            int lastRefill = currentRefill;
            //System.out.println("lastRefill : " + lastRefill); // check the last position of car

            //checking the current position of car and the will it reach the next refill point
            while (currentRefill < n && (X[currentRefill + 1] - X[lastRefill]) <= L) {
                currentRefill = currentRefill + 1;
            }

            // if it won't reach the next refill point
            if (currentRefill == lastRefill) {
                return -1;
            }

            // if it reaches the next refill point
            if (currentRefill < n) {
                numRefills = numRefills + 1;
            }
        }
        return numRefills;
    }
}
