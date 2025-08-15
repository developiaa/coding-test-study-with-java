package baekjoon.stack._16120;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.next().toCharArray();

        char[] stack = new char[ch.length];
        int index = 0;
        for (char c : ch) {
            stack[index++] = c;
            if (index >= 4 && stack[index - 1] == 'P' && stack[index - 2] == 'A' &&
                    stack[index - 3] == 'P' && stack[index - 4] == 'P') {
                index -= 3;
            }
        }

        if (index == 1 && stack[0] == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
