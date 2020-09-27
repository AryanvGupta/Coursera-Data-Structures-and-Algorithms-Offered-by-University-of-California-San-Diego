package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt(); // size of array/list
        long[] numbers = new long[n];
        // elements of array/list
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //StressTest(numbers);
        System.out.println(MaxPairwiseProductFast(numbers));
    }

    // this method is highly accurate but computation time is much more
    static long MaxPairwiseProductNaive(long[] numbers) {
        long product = 0;
        int n = numbers.length;
        // sorting the array
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                // finding the product
                long a = numbers[i] * numbers[j];
                // comapring the product, whose value will varry till the highest value is found
                product = Math.max(product, a);
            }
        }
        return product;
    }

    // this method resolves the computation time problem
    static long MaxPairwiseProductFast(long[] numbers) {

        int index1 = 0;
        int index2;
        // finding the largest no.
        for (int i=1; i<numbers.length; i++){
            if (numbers[i] > numbers[index1]) {
                index1 = i;
            }
        }

        // condition to check that second highest no. and highest no. are not same (same index)
        if (index1 == 0){
            index2 = 1;
        }
        else {
            index2 = 0;
        }

        // finding the second highest no.
        for (int i=0; i<numbers.length; i++) {
            if (i != index1 && numbers[i] > numbers[index2]) {
                index2 = i;
            }
        }

        long a = numbers[index1] * numbers[index2]; // ans
        //System.out.println(numbers[index1] + "  :  " + numbers[index2]);
        return a;
    }

    // it is used to compare the result of the above two methods which gives more accurecy
    // it is a test which is highly effective
    public static void StressTest(long[] numbers) {
        boolean flag = true;
        while (flag) {
            for (int i=0; i<numbers.length; i++) {
                System.out.println(numbers[i]);
            }
            long result1 = MaxPairwiseProductNaive(numbers);
            long result2 = MaxPairwiseProductFast(numbers);
            // comparing the result of the above two methods
            if (result1 == result2) {
                System.out.println("OK");
            }
            else {
                System.out.println("Wrong answer: " + result1 + " " + result2);
            }
            return;
        }
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}