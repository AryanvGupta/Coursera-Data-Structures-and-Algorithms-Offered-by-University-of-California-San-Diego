package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public static class is_bst {
        class FastScanner {
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

        public class IsBST {
            class Node {
                int key;
                int left;
                int right;

                Node(int key, int left, int right) {
                    this.left = left;
                    this.right = right;
                    this.key = key;
                }
            }

            int nodes;
            Node[] tree;

            void read() throws IOException {
                FastScanner in = new FastScanner();
                nodes = in.nextInt();
                tree = new Node[nodes];
                for (int i = 0; i < nodes; i++) {
                    tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
                }
            }

            boolean isBinarySearchTree() {
                for (int i=0;i<nodes;i++) {
                }
                return true;
            }
        }

        public void run() throws IOException {
            IsBST tree = new IsBST();
            tree.read();
            if (tree.isBinarySearchTree()) {
                System.out.println("CORRECT");
            } else {
                System.out.println("INCORRECT");
            }
        }
    }
}
