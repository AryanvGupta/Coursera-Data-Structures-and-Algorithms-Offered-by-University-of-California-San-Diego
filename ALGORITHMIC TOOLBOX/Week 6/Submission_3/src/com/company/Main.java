package com.company;

import java.util.Scanner;

// Find the maximum value of an arithmetic expression by specifying the order
// of applying its arithmetic operations using additional parentheses.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String exp = scanner.next();

        System.out.println(getMaximValue(exp));
    }

    private static long getMaximValue(String exp) {
        // n denotes # of digits in the expression
        int n = exp.length() / 2 + 1;
        // build up both max and min from subexpressions
        long[][] min = new long[n][n], max = new long[n][n];
        // for subexpression of size 0, i==j, min=max=digit
        for(int i = 0; i < n; i++) {
            min[i][i] = exp.charAt(i * 2) - '0';
            max[i][i] = exp.charAt(i * 2) - '0';
        }
        // traverse each size of subexpressions from
        // j-i=1 (Di OPi Di+1) to j-i=n-1 (D1..Dn-1 OPn-1 OPn);
        for(int size = 1; size <= n - 1; size++) {
            // fill in right-up half of the matrix through diagonal
            for(int i = 0; i <= n - 1 - size; i++) {
                int j = size + i;  // maintain j - i = size
                long[] res = getMinAndMax(exp, i, j, min, max);
                min[i][j] = res[0];
                max[i][j] = res[1];
            }
        }
        // max of eval(1..n)
        return max[0][n - 1];
    }

    private static long[] getMinAndMax(String exp, int i, int j, long[][] min, long[][] max) {
        long[] res = new long[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int index = i; index <= j - 1; index++) {
            // Map OPindex to character of exp
            char oper = exp.charAt(index * 2 + 1);
            // Combinations of mm, mM, Mm, MM
            long a = eval(min[i][index], min[index + 1][j], oper),
                    b  = eval(min[i][index], max[index + 1][j], oper),
                    c  = eval(max[i][index], min[index + 1][j], oper),
                    d  = eval(max[i][index], max[index + 1][j], oper);
            res[0] = Math.min(a, Math.min(b,
                    Math.min(c, Math.min(d, res[0]))));
            res[1] = Math.max(a, Math.max(b,
                    Math.max(c, Math.max(d, res[1]))));
        }
        return res;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }
}
