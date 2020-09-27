package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt(); // no of segments
        m = scanner.nextInt(); // no. of points

        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];

        // segment
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt(); // starting point of segment
            ends[i] = scanner.nextInt(); // ending point of segment
        }

        // point
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt(); // points
        }

        for (int i=0;i<m;i++) {
            int result = countPoints(n,m,points,starts,ends);
            System.out.println(result + " ");
        }

        //use fastCountSegments
        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }

    }

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        Arrays.sort(points);

        for (int i=0;i<points.length;i++) {

        }

        return cnt;
    }

    static int countPoints(int n, int m, int[] b, int[] x, int[] y)
    {
        // Sort both the vectors
//        Arrays.sort(a);
        Arrays.sort(b);

        // Initially pointing to the first element of b[]
        int j = 0;
        int count = 0;
        for (int i = 0; i < n; i++)
        {

            // Try to find a match in b[]
            while (j < m)
            {

                // The segment ends before b[j]
                if (a[i] + y < b[j])
                    break;

                // The point lies within the segment
                if (b[j] >= a[i] - x && b[j] <= a[i] + y)
                {
                    count++;
                    j++;
                    break;
                }

                // The segment starts after b[j]
                else
                    j++;
            }
        }

        // Return the required count
        return count;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }
}
