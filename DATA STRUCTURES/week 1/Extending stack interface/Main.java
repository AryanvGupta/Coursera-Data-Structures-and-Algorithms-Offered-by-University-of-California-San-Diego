package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }

    public static class StackWithMax {
        static class FastScanner {
            StringTokenizer tok = new StringTokenizer("");
            BufferedReader in;

            FastScanner() {
                in = new BufferedReader(new InputStreamReader(System.in));
            }

            String next() throws IOException {
                while (!tok.hasMoreElements())
                    tok = new StringTokenizer(in.readLine());
                return tok.nextToken();
            }
            int nextInt() throws IOException {
                return Integer.parseInt(next());
            }
        }

        public void solve() throws IOException {
            FastScanner scanner = new FastScanner();
            int queries = scanner.nextInt();
            Stack<Integer> stack = new Stack<Integer>();
            int[] max_ele = new int[queries];
            int value = 0, i = 1;
            max_ele[0] = 0;

            for (int qi = 0; qi < queries; ++qi) {
                String operation = scanner.next();
                if ("push".equals(operation)) {
                    value = scanner.nextInt();
                    stack.push(value);
                    if (value >= max_ele[i-1]) {
                        max_ele[i] = value;
                        i++;
                    }
                } else if ("pop".equals(operation)) {
                    int del = stack.pop();
                    //System.out.println(stack);
                    if (del == max_ele[i-1]) {
                        i--;
                    }
                } else if ("max".equals(operation)) {
                    //System.out.println(Collections.max(stack));
                    if (stack.contains(max_ele[i-1])) {
                        System.out.println(max_ele[i-1]);
                    }
                    else {
                        System.out.println(max_ele[i-2]);
                    }
                }
            }
            //System.out.println(Arrays.toString(max_ele));
        }
    }
}


