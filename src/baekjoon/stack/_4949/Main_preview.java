package baekjoon.stack._4949;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.equals(".")) {
                break;
            }

            char[] charArray = s.toCharArray();
            Deque<Character> deque = new ArrayDeque<>();
            boolean isValid = true;
            for (char c : charArray) {
                if (c == '(' || c == '[') {
                    deque.addLast(c);
                } else if (c == ')' || c == ']') {
                    if (!deque.isEmpty() && isMatch(deque.peekLast(), c)) {
                        deque.removeLast();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                if (!deque.isEmpty()) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isMatch(Character pop, char c) {
        if (pop == '(' && c == ')') {
            return true;
        } else return pop == '[' && c == ']';
    }
}
