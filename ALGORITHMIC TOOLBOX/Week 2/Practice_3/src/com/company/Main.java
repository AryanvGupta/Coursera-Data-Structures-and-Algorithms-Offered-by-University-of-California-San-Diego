package com.company;

// Runtime BigO notation

public class Main {

    public static void main(String[] args) {

        /*
        Asymptotic Notation
        log(n) < sqrt(n) < n < n*log(n) < n^2 < 2^n

        Big-O notation
        f(n) = O(g(n))
        or,
        f <= g  if,
        N and c = constants for all
        n >= N  , f(n) <= c*g(n)

        It clarifies the growth rate.
        3n^2 + 5n + 2 --> O(n^2)

        No need to worry about Runtime.
        it allows to have a constant scale with a efficient method

        It losses important constants.

        eg:

        7n^3 = O(n^3), (n^2)/3 = O(n^2)

        n^a < n^b  for  0<a<b
        n = O(n^2), sqrt(n) = O(n)

        n^a < b^n  for  a>0, b>1
        n^5 = O(2^(1/n)), n^100 = O(1.1^n)

        (log(n))^a < n^b  for a,b>0
        (log(n))^3 = O(sqrt(n)), n*log(N) = O(n^2)

        smaller terms can be omitted
        n^2 + n = O(n^2), 2^n + n^9 = O(2^n)


        other notations
        omega notation similar to Big-O

         */

    }
}
