package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

// Types of sorting

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int n = scanner.nextInt(); // no. of inputs
        long[] array = new long[n]; // array to store input
        for (int i=0; i<n; i++) {
            array[i] = scanner.nextInt();
        }

//        System.out.println("Selection Sort : ");
//        System.out.println(Arrays.toString(selection_sort(array)));
//
//        System.out.println("Merge Sort : ");
//        System.out.println(Arrays.toString(merge_sort(array,n)));
//
//        System.out.println("Quick Sort : ");
//        System.out.println(Arrays.toString(quick_sort(array,0,n)));

        //System.out.println("Randomized Quick Sort : ");
        long[] result = modified_quick_sort(array,0,n);
        for (int i=0;i<n;i++) {
            System.out.println(result[i] + " ");
        }
    }

    // modified quick sort (when multiple elements are equal)
    private static long[] modified_quick_sort(long[] array, long left, long right) {

        if (left >= right) {
            return array;
        }

        Random random = new Random();

        int random_piviot = (int) left;

        long temp;
        temp = array[(int) left];
        array[(int) left] = array[random_piviot];
        array[random_piviot] = temp;

        int[] f = modified_partition(array,(int) left,(int) right);
        int mid1 = f[0];
        int mid2 = f[1];

        modified_quick_sort(array,left,mid1-1);
        modified_quick_sort(array,mid2+1,right);

//        if (left >= right) {
//            return array;
//        }
//        long lt =  left;
//        long gt = right;
//        int i = (int) (left + 1);
//
//        long pivot_index = left;
//        long pivot_value = array[(int) pivot_index];
//
//        while (i <= gt) {
//            if (array[i] < pivot_value) {
//                long temp;
//                temp = array[i];
//                array[i] = pivot_value;
//                pivot_value = temp;
//                i++;
//                lt++;
//            }
//            else if (pivot_value < array[i]) {
//                long temp;
//                temp = array[i];
//                array[i] = pivot_value;
//                pivot_value = temp;
//                gt--;
//            }
//            else {
//                i++;
//            }
//        }
//
//        modified_quick_sort(array,left,lt-1);
//        modified_quick_sort(array,gt+1,right);

//        int i=0,j=0;
//
//        int[] f = modified_partition(array,(int) left,(int) right,i,j);
//        f[0] = i;
//        f[1] = j;
//
//        modified_quick_sort(array,left,i);
//        modified_quick_sort(array,j,right);
//
//        System.out.println(Arrays.toString(array));

//        int k = (int) ((left+right)/2); // k = any random value from l to r
//
//        // swapping
//        long temp;
//        temp = array[(int) left];
//        array[(int) left] = array[k];
//        array[k] = temp;
//
//        long m1 = partition(array,left,right);
//        long m2 = partition(array,left,right);
//
//        modified_quick_sort(array,left,m1);
//        modified_quick_sort(array,m2+1,right);
//
        return array;
    }

    private static int[] modified_partition(long[] arr, int left, int right) {

//        System.out.println(left + " : " + right);
//

         int pivot = (int) arr[left];
         int i = left;
         int j = 0;
         int lt = left;
         int gt = right;
         int[] f = new int[]{i,j};

         while (i <= gt) {
             if (arr[i] < pivot) {
                 long temp;
                 temp = arr[i];
                 arr[i] = arr[lt];
                 arr[lt] = temp;
             }
             else if (arr[i] > pivot) {
                 long temp;
                  temp = arr[i];
                  arr[i] = arr[gt];
                  arr[gt] = temp;
             }
             else {
                 i++;
             }
         }
         i = lt;
         j = gt;

//
//        if ((right-left) <= 1) {
//            if (arr[right] < arr[left]) {
//                long temp;
//                temp = arr[left];
//                arr[left] = arr[right];
//                arr[right] = temp;
//            }
//            i = left;
//            j = right;
//            return f;
//        }
//        System.out.println(i + " : " + j);
//
//        int mid = left;
//        long pivot = arr[right-2];
//        System.out.println(mid + " : " + right);
//        while (mid <= right) {
//            if (arr[mid] < pivot) {
//                long temp;
//                temp = arr[left];
//                arr[left] = arr[mid];
//                arr[mid] = temp;
//                left++;
//                mid++;
//            }
//            else if (arr[mid] == pivot) {
//                mid++;
//            }
//            else {
//                long temp;
//                temp = arr[right-1];
//                arr[right-1] = arr[mid];
//                arr[mid] = temp;
//                right--;
//            }
//        }
//        i = left - 1;
//        j = mid;
        return f;
    }

    // quick sort avg : O(n*log(n)) ; worst : O(n*n)
    private static long[] quick_sort(long[] array, long l, long r) {
        if (l >= r) {
            return array;
        }
        long m = partition(array,l,r);
        quick_sort(array,l,m);
        quick_sort(array,m+1,r);
        return array;
    }

    private static long partition(long[] array, long l, long r) {
        long pivot = array[(int) l];
        int j = (int) l-1;

        for (int i = (int) (l); i<r; i++) {
            if (array[i] <= pivot) {
                j = j + 1;
                long temp;
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        long temp;
        temp = array[(int) l];
        array[(int) l] = array[j];
        array[j] = temp;
        return j;
    }

    // merge sort O(n*log(n))
    public static long[] merge_sort(long[] a, long n) {
        if (n < 2) {
            return a;
        }
        int mid = (int) (n / 2);
        long[] l = new long[mid];
        long[] r = new long[(int) (n - mid)];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        merge_sort(l, mid);
        merge_sort(r, n - mid);

        return merge(a, l, r, mid, n - mid);
    }

    public static long[] merge(long[] a, long[] l, long[] r, long left, long right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

        return a;
    }


    // selection sort
    private static long[] selection_sort(long[] array) {
        int n = array.length;

        for (int i=0; i<n; i++) { // main loop
            int min_index = i;
            for (int j=i+1; j<n; j++) { // loop to compare the min_index
                if (array[j] < array[min_index]) {
                    min_index = j; // if condition true
                }
            }
            // swapping to sort the array
            long temp;
            temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
        return array;
    }

}
