package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int n = scanner.nextInt(); // no. of inputs

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt(); // sorted array
        }

        int m = scanner.nextInt(); // no of keys to search

        int[] keys = new int[m];
        for (int i = 0; i < m; i++) {
            keys[i] = scanner.nextInt(); // keys
        }

        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(BinarySearch_new(values,0, n-1, keys[i]) + " ");
//            System.out.print(binary_recursion(values,i, n, keys[i]) + " ");
//            System.out.print(binary_iterative(values, keys[i]) + " ");
        }
    }

    public static int binary_iterative(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (array[mid] == x) {
                return mid;
            }
            else if (x < array[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binary_recursion(int[] array, int left, int right, int x) {
        if (left > right) {
            return -1;
        }

        int mid = ((right - left) / 2);

        if (array[mid] == x) {
            return mid;
        }
        else if (x < array[mid]) {
            return binary_recursion(array,x,left,mid);
        }
        else {
            return binary_recursion(array,x,mid+1,right);
        }
    }

    public static int BinarySearch_new(int[] Arr,int low,int high,int key){
        if (high < low)
            return - 1;
        int mid = low+((high-low)/2);
        //System.out.println("mid:"+mid);
        if(Arr[mid] == key)
            return mid;
        else if(Arr[mid] > key)
            return BinarySearch_new(Arr,low,mid-1,key);
        else if(Arr[mid] < key)
            return BinarySearch_new(Arr,mid+1,high,key);
        return -1;
    }



    public static long binarySearch(long[] array, long low, long high, long key) {

        if (high < low) {
            return -1;
        }


        long mid = low + ((high - low)/2);
        System.out.println("mid : " + mid);

            // condition to check if we don't find the key in array

                if (key == array[(int) mid]) {
                    return mid;
                }
                else if (key < array[(int) mid]) {
                    return binarySearch(array,low,mid-1,key);
                }
                else {
                    return binarySearch(array,mid+1,high,key);
                }



    }
}
