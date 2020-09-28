package com.company;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        int n = scanner.nextInt();
        int[] key = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i=0;i<n;i++) {
            key[i] = scanner.nextInt();
            left[i] = scanner.nextInt();
            right[i] = scanner.nextInt();
        }

        for (int i=0;i<n;i++) {
            binaryTree.root = new Node(key[i]);
        }

        binaryTree.printInorder(binaryTree.root);
        binaryTree.printPreorder(binaryTree.root);
        binaryTree.printPostorder(binaryTree.root);
    }


    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        // Root of Binary Tree
        Node root;

        BinaryTree() {
            root = null;
        }

        /* Given a binary tree, print its nodes according to the
          "bottom-up" postorder traversal. */
        void printPostorder(Node node) {
            if (node == null)
                return;

            // first recur on left subtree
            printPostorder(node.left);

            // then recur on right subtree
            printPostorder(node.right);

            // now deal with the node
            System.out.print(node.key + " ");
        }

        /* Given a binary tree, print its nodes in inorder*/
        void printInorder(Node node) {
            if (node == null)
                return;

            /* first recur on left child */
            printInorder(node.left);

            /* then print the data of node */
            System.out.print(node.key + " ");

            /* now recur on right child */
            printInorder(node.right);
        }

        /* Given a binary tree, print its nodes in preorder*/
        void printPreorder(Node node) {
            if (node == null)
                return;

            /* first print data of node */
            System.out.print(node.key + " ");

            /* then recur on left sutree */
            printPreorder(node.left);

            /* now recur on right subtree */
            printPreorder(node.right);
        }
    }
}
