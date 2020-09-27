package com.company;

// Given 𝑛 gold bars,
// find the maximum weight of gold that fits into a bag of capacity 𝑊.

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int W, n;
        W = scanner.nextInt(); // Max weight of bag
        n = scanner.nextInt(); // number of items
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt(); // weight of i item
        }
        System.out.println(solution(W, w));
    }

    private static int solution(int W, int[] w) {
        int n = w.length;
        int[][] value = new int[W+1][n+1];
        int ans = 0;

        value[0][n] = 0;
        value[W][0] = 0;

        for (int i=1;i<n;i++) {
            for (int j=0;j<W;j++) {
                value[j][i] = value[j][i-1];
                if (w[i] <= j) {
                    int val = value[j-w[i]][i-1] + 1;
                    if (value[j][i] < val) {
                        value[j][i] += val;
                    }
                }
            }
        }
        return value[W-1][n-1];
    }

    static int knap(int c, int[] weight)
    {  int i, space, m, t,
            maxKnown[], itemKnown[], solution[];

        itemKnown = new int [c+1];
        maxKnown  = new int [c+1];
// If Java didn't fill with zeroes we'd need
// java.util.Arrays.fill(maxKnown,flag);
        for ( m = 0; m < c; m++ )
            for (i = 0; i < weight.length; i++)
                if ( (space = m-weight[i]) >= 0 )
                {  t = maxKnown[space] ;
                    // Dummy:  wt 1, value 0
                    if ( t >= maxKnown[m] )
                    {  maxKnown[m]  = t;
                        itemKnown[m] = i;
                    }
                }
// State of solution[] is unknown, so
        java.util.Arrays.fill (weight, 0);
        for (m=c; m>0 ; m-=weight[itemKnown[m]] )
            weight[itemKnown[m]]++;
        return maxKnown[c];
    }

    private static int M(int C, int[] w)
    {
        int[] sol, mySol;
        int i, myFinalSol;
        int ans = 0;

        sol   = new int[w.length];
        mySol = new int[w.length];

       /* ---------------------------
          Base cases
          --------------------------- */
        if ( C == 0 )
        {
            return(0);
        }

       /* ==============================================
          Divide and conquer procedure
          ============================================== */
       /* ---------------------------------------
          Solve the appropriate smaller problems
          --------------------------------------- */
        for ( i = 0; i < w.length; i++ )
        {
            if ( C >= w[i] ) {
                sol[i] = M(C-w[i], w ); // Knapsack capacity reduced by w[i]
                // because it has item i packed in
                // it already
            }
            else
                sol[i] = 0;        // Not enough space to  pack item i
        }

       /* ---------------------------------------------
          Use the solutions to the smaller problems
          to solve original problem
          --------------------------------------------- */
        for ( i = 0; i < w.length; i++ )
        {
            if ( C >= w[i] )
                mySol[i] = sol[i] ;   // Value is increased by v[i]
                // because it has item i packed in
                // it already
            else
                mySol[i] = 0;        // Not enough space to  pack item i
        }

       /* *************************
          Find the best (maximum)
          ************************* */
        myFinalSol = mySol[0];
        for ( i = 1; i < w.length; i++ )
            if ( mySol[i] > myFinalSol )
                myFinalSol = mySol[i];
        return ans;       // Return the overal best solution
    }

    private static int M_dp(int W, int[] w)
    {
        int[] sol, mySol;
        int i, myFinalSol;

        int[] M;                 // Data structure to store results
        int   C;                 // Index to run through M[]

        sol   = new int[w.length];
        mySol = new int[w.length];

        M = new int[W + 1];      // Create array

       /* ---------------------------
          Base cases
          --------------------------- */
        M[0] = 0;

       /* ==============================================
          The other values M[C]
          ============================================== */
        for ( C = 1; C <= W; C++ )
        {
          /* ---------------------------------------
             Solve the appropriate smaller problems
             --------------------------------------- */
            for ( i = 0; i < w.length; i++ )
            {
                if ( C >= w[i] )
                    sol[i] = M[ C-w[i] ]; // Knapsack capacity reduced by w[i]
                    // because it has item i packed in
                    // it already
                else
                    sol[i] = 0;        // Not enough space to  pack item i
            }

          /* ---------------------------------------------
             Use the solutions to the smaller problems
             to solve original problem
             --------------------------------------------- */
            for ( i = 0; i < w.length; i++ )
            {
                if ( C >= w[i] )
                    mySol[i] = sol[i];   // Value is increased by v[i]
                    // because it has item i packed in
                    // it already
                else
                    mySol[i] = 0;        // Not enough space to  pack item i
            }

          /* *************************
             Find the best (maximum)
             ************************* */
            M[C] = mySol[0];
            for ( i = 1; i < w.length; i++ )
                if ( mySol[i] > M[C] )
                    M[C] = mySol[i];
        }

        return M[ W ];     // Return best value for knapsack of cap = W
    }

    private static int optimalWeightEfficient(int W, int[] w) {
        int n = w.length;
        int[][] value = new int[n+1][W+1];
        int val;

        for (int i=1;i<n;i++) {
            for (int j=0;j<W;j++) {
                System.out.println("i : " + i + " && " + "j : " + j);
                value[i][j] = value[i-1][j];
                if (w[i] <= j) {
                    val = value[i-1][j-w[i]];
                    if (value[i][j] < val) {
                        value[i][j] = val;
                    }
                }
                System.out.println("K[i][j] : " + value[i][j]);
            }
        }
        return value[n-1][n-1];
    }

    private static int optimalWeight(int W, int[] w) {
        Arrays.sort(w);
        int n = w.length;
        int max = 0;

        int[][] values = new int[n][n];
        System.out.println(Arrays.toString(w));
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                System.out.println("i : " + i + " && " + "j : " + j);
                values[i][j] = w[i] + w[j];
                System.out.println("values[i][j] : " + values[i][j]);
            }
        }

        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                if (values[i][j] > max && values[i][j] <= W) {
                    System.out.println("i : " + i + " - " + "j : " + j);
                    max = values[i][j];
                    System.out.println("max : " + max);
                }
            }
        }
        return max;


//        int gold_weight = 0;
//
//        for (int i=n;i>0;i--) {
//            System.out.println("i : " + i);
//            max = w[i];
//            System.out.println("max : " + max);
//            if (max > W) {
//                max = w[i-1];
//                System.out.println("max : " + max);
//            }
//            W = W - max;
//            System.out.println("W : " + W);
//            if (W >= 0) {
//                gold_weight += max;
//            }
//            System.out.println("gold_weight : " + gold_weight);
//        }
//        return gold_weight;


//        int result = 0;
//        for (int i = 0; i < w.length; i++) {
//            if (result + w[i] <= W) {
//                result += w[i];
//            }
//        }
//        return result;
    }
}
