package com.company;

import java.util.Scanner;

// Linear Search
// A = array of values ; low = lower bound ; high = higher bound ; key = value for which to search

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] values = new int[]{1,2,3,4,5,6,7,8,9,0};
        int key = 5;
        System.out.println(linearSearch(values,0,values.length,key));
    }

    public static int linearSearch(int[] array, int low, int high, int key) {
        if (high < low) {
            return -1;
        }
        if (array[low] == key) {
            return low;
        }
        return linearSearch(array,low+1, high, key); // returns the index of key
    }
}
