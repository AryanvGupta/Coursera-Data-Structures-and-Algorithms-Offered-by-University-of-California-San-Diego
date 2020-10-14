package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        //       Scanner reader = new Scanner(new FileInputStream("files/EulerianCycle.txt"));

        int V = reader.nextInt();
        int E = reader.nextInt();

        List[] edgesFrom = new List[V];
        for (int i = 0; i < V; i++) {
            edgesFrom[i] = new ArrayList<EulerianCycle.Edge>();
        }

        int in[] = new int[V];
        int out[] = new int[V];

        for (int i = 0; i < E; i++) {
            int from = reader.nextInt() - 1;
            int to = reader.nextInt() - 1;
            edgesFrom[from].add(new EulerianCycle.Edge(from, to));
            in[to]++;
            out[from]++;
        }

        for (int i = 0; i < V; i++) {
            //if Euler cycle exists inbound and outbound edges for single vertex should be same
            //also if number of edges is 0 vertex is isolated, no cycle
            if (in[i] != out[i] || in[i] == 0 || out[i] == 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
        List<Integer> eulerianPath = new ArrayList<Integer>();
        EulerianCycle.dfs(0, eulerianPath, edgesFrom);

        for (int i = eulerianPath.size() - 1; i > 0; i--) {
            System.out.print(1 + eulerianPath.get(i) + " ");
        }
        System.out.println();
    }
}

class EulerianCycle {

    protected static void dfs(int v, List<Integer> path, List<Edge>[] edgesFrom) {
        for (Edge e : edgesFrom[v]) {
            if (!e.used) {
                e.used = true;
                dfs(e.to, path, edgesFrom);
            }
        }
        path.add(v);
    }


    protected static class Edge {
        int from, to;
        boolean used = false;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
