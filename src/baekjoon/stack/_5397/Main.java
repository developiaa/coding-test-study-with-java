package baekjoon.stack._5397;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Deque<Character> left = new LinkedList<>();
            Deque<Character> right = new LinkedList<>();

            char[] ch = sc.next().toCharArray();
            for (char c : ch) {
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.offerLast(left.pollLast());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.offerLast(right.pollLast());
                    }
                } else if (c == '-') {
                    left.pollLast();
                } else {
                    left.offerLast(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) sb.append(left.pollFirst());
            while (!right.isEmpty()) sb.append(right.pollLast());
            System.out.println(sb);
        }
    }
}
