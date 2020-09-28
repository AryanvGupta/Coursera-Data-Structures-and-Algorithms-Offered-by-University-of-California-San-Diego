package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

//    public static int n = scanner.nextInt();

//    public static int[] swap_elements = new int[n];

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }

        int j = 0;
        Object[] swap_ele = new Object[2*n];
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
//            swap_ele = heapify(arr, n, i);
//            for (j=0;j<swap_ele.length;j++) {
//                System.out.print(swap_ele[j] + " ");
//            }

            j = heapify(arr, n, i);
        }
        System.out.println(j);
        swap_ele = swap_elements.toArray();
        for (int i=0;i<swap_elements.size();i=i+2) {
            System.out.println(swap_ele[i] + " " + swap_ele[i+1]);
        }

//        System.out.println(swap_count);
//        System.out.println(Arrays.toString(swap_elements));
    }

    public static int swap_count = 0;
    public static List<Integer> swap_elements = new ArrayList<>();
    static int heapify(int[] arr, int n, int i)
    {
        int smallest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        // If largest is not root
        if (smallest != i) {
            swap_elements.add(i);
            swap_elements.add(smallest);
            swap_count += 1;
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
            //System.out.println(i + " " + smallest);
            // Recursively heapify the affected sub-tree
            heapify(arr, n, smallest);
        }
        return swap_count;
    }

    // Function to build a Max-Heap from the Array
    static void buildHeap(int[] arr, int n)
    {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
        //System.out.println(Arrays.toString(swap_elements));
    }


    // HEAP SORT ...! ( BELOW )

    public static int size;
    public static int maxsize = 100;
    public static int[] heap = new int[maxsize];

    private static void partialSorting(int[] A, int k) {
        buildHeap(A);
        for (int i=0;i<k;i++) {
            extractMax();
        }
    }

    public static int parent(int i) {
        return i/2;
    }

    public static int leftChild(int i) {
        return i*2;
    }

    public static int rightChild(int i) {
        return (i*2)+1;
    }

    public static void buildHeap(int[] A) {

    }

    public static void shiftDown(int i) {
        int maxIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l<size && heap[l]>heap[maxIndex]) {
            maxIndex = l;
        }
        if (r<size && heap[r]>heap[maxIndex]) {
            maxIndex = r;
        }
        if (i != maxIndex) {
            int temp;
            temp = heap[maxIndex];
            heap[maxIndex] = heap[i];
            heap[i] = temp;
            shiftDown(maxIndex);
        }
    }

    public static void shiftUp(int i) {
        while (i>1 && heap[parent(i)] < heap[i]) {
            int temp;
            temp = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = temp;
            i = parent(i);
        }
    }

    public static int extractMax() {
        int result = heap[1];
        heap[1] = heap[size];
        size = size - 1;
        shiftDown(1);
        return result;
    }

    public static void insert(int p) {
        int maxsize = 0;
        if (size == maxsize) {
            return;
        }
        size = size + 1;
        heap[size] = p;
        shiftUp(size);
    }

    public static void changePriority(int i, int p) {
        int old_p = heap[i];
        heap[i] = p;
        if (p>old_p) {
            shiftUp(i);
        }
        else {
            shiftDown(i);
        }
    }

    public static void remove(int i) {
        heap[i] = Integer.MAX_VALUE;
        shiftUp(i);
        extractMax();
    }
}
