package com.company;

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        GSMNetwork.InputReader reader = new GSMNetwork.InputReader(System.in);
        GSMNetwork.OutputWriter writer = new GSMNetwork.OutputWriter(System.out);
        new GSMNetwork(reader, writer).run();
        writer.writer.flush();
    }
}

class GSMNetwork {
    private final InputReader reader;
    private final OutputWriter writer;

    public GSMNetwork(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    class Edge {
        int from;
        int to;
    }

    class ConvertGSMNetworkProblemToSat {
        int numVertices;
        Edge[] edges;

        ConvertGSMNetworkProblemToSat(int n, int m) {
            numVertices = n;
            edges = new Edge[m];
            for (int i = 0; i < m; ++i) {
                edges[i] = new Edge();
            }
        }


        void printEquisatisfiableSatFormula() {
            // This solution prints a simple satisfiable formula
            // and passes about half of the tests.
            // Change this function to solve the problem.
            StringBuilder clauses = new StringBuilder((4 * numVertices + 3 * edges.length) + " " + 3 * numVertices + "\n");
            hasUniqueColor(clauses);
            differentColorForNeighbours(clauses);
            writer.printf(clauses.toString());
        }

        private void differentColorForNeighbours(StringBuilder clauses) {
            for (Edge edge : edges) {
                int from = edge.from;
                int to = edge.to;

                clauses.append(-(from * 3 - 2))
                        .append(" ")
                        .append(-(to * 3 - 2))
                        .append(" 0\n")
                        .append(-(from * 3 - 1))
                        .append(" ")
                        .append(-(to * 3 - 1))
                        .append(" 0\n")
                        .append(-(from * 3))
                        .append(" ")
                        .append(-(to * 3))
                        .append(" 0\n");
            }
        }


        private void hasUniqueColor(StringBuilder clauses) {
            for (int i = 1; i < numVertices * 3 + 1; i += 3) {
                clauses.append(i)
                        .append(" ")
                        .append(i + 1)
                        .append(" ")
                        .append(i + 2)
                        .append(" 0\n")

                        .append(-i)
                        .append(" ")
                        .append(-(i + 1))
                        .append(" 0\n")
                        .append(" ")
                        .append(-i)
                        .append(" ")
                        .append(-(i + 2))
                        .append(" 0\n")
                        .append(-(i + 1))
                        .append(" ")
                        .append(-(i + 2))
                        .append(" 0\n");
            }
        }
    }

    public void run() {
        int n = reader.nextInt();
        int m = reader.nextInt();

        ConvertGSMNetworkProblemToSat converter = new ConvertGSMNetworkProblemToSat(n, m);
        for (int i = 0; i < m; ++i) {
            converter.edges[i].from = reader.nextInt();
            converter.edges[i].to = reader.nextInt();
        }

        converter.printEquisatisfiableSatFormula();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class OutputWriter {
        public PrintWriter writer;

        OutputWriter(OutputStream stream) {
            writer = new PrintWriter(stream);
        }

        public void printf(String format, Object... args) {
            writer.print(String.format(Locale.ENGLISH, format, args));
        }
    }
}