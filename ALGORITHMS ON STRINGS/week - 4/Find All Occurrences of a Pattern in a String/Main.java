package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static public void main(String[] args) throws IOException {
        new KnuthMorrisPratt().run();
    }
}

class KnuthMorrisPratt {
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

    // Find all the occurrences of the pattern in the text and return
    // a list of all positions in the text (starting from 0) where
    // the pattern starts in the text.
    public List<Integer> findPattern(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String string = pattern + "$" + text;
        int[] s = calculatePrefixFunction(string);
        int patternLength = pattern.length();
        for (int i = patternLength; i < string.length(); i++) {
            if (s[i] == patternLength) result.add(i - patternLength * 2);
        }
        return result;
    }

    public int[] calculatePrefixFunction(String text) {
        int[] result = new int[text.length()];
        int border = 0;
        for (int i = 1; i < text.length(); i++) {
            while (border > 0 && text.charAt(i) != text.charAt(border)) {
                border = result[border - 1];
            }
            if (text.charAt(i) == text.charAt(border)) {
                border++;
            } else {
                border = 0;
            }
            result[i] = border;
        }
        return result;
    }

    public void print(List<Integer> x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String pattern = scanner.next();
        String text = scanner.next();
        List<Integer> positions = findPattern(pattern, text);
        print(positions);
    }
}
