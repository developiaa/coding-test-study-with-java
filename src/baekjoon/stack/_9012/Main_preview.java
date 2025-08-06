package baekjoon.stack._9012;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] ch = sc.next().toCharArray();
            boolean isValid = true;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '(') {
                    stack.addLast(ch[i]);
                } else if (ch[i] == ')') {
                    if (!stack.isEmpty()) {
                        stack.removeLast();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
