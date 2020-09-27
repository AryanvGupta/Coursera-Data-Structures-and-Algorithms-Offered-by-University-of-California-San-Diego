package com.company;

// Given an integer 𝑛, compute the minimum number of operations needed to obtain
// the number 𝑛 starting from the number 1.
// multiply 𝑥 by 2, multiply 𝑥 by 3, or add 1 to 𝑥.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // integer

        List<Integer> sequence = greedy_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<>();

        return sequence;
    }

    private static List<Integer> greedy_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
}
