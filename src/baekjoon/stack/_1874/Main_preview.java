package baekjoon.stack._1874;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int index = 1;
        boolean isPossible = true;
        while (n-- > 0) {
            int num = sc.nextInt();
            while (index <= num) {
                stack.push(index++);
                sb.append("+").append("\n");
            }
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                isPossible = false;
            }
        }
        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}