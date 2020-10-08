package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Reachable

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // vertices
        int m = scanner.nextInt(); // edges

        // map
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // storing values in List
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            //System.out.println("x:" + (x-1) + " <--> " + "y:" + (y-1));
            adj[x-1].add(y-1);
            adj[y-1].add(x-1);
        }

        //System.out.println(Arrays.toString(adj));

        int x = scanner.nextInt() - 1; // vertice 1
        int y = scanner.nextInt() - 1; // vertice 2
        //System.out.println("x:" + x + " <--> " + "y:" + y);

        System.out.println(reachnew(adj, x, y));
    }

    private static int reachnew(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        int[] visited = new int[adj.length];
        return explore(adj, x, y, visited);
    }

    private static int explore(ArrayList<Integer>[] adj, int x, int y, int[] visited) {
        if (x == y) {
            return 1;
        }
        visited[x] = 1;
        for (int i = 0; i < adj[x].size(); i++) {
            if (visited[adj[x].get(i)] == 0) {
                if(explore(adj, adj[x].get(i), y, visited) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        int i=0;
        if (adj[x].contains(y)) {
            //System.out.println("first if");
        }
        else {
            for (i=0;i<y+1;i++) {
                if (adj[i].contains(i+1) && (i != y)){
//                    System.out.println("second if");
//                    System.out.println("i:" + i);
                }
                else if (adj[i].contains(i-1) && (i == y)){

                }
                else
                    return 0;
            }
        }
        return 1;
    }
}
