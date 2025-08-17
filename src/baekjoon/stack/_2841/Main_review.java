package baekjoon.stack._2841;

import java.util.*;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();

        Deque<Integer>[] stack = new ArrayDeque[N + 1];
        for (int i = 1; i <= N; i++) {
            stack[i] = new ArrayDeque<>();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int fret = sc.nextInt();

            while (!stack[num].isEmpty() && stack[num].peekLast() > fret) {
                stack[num].pollLast();
                count++;
            }

            if (!stack[num].isEmpty() && stack[num].peekLast() == fret) {
                continue;
            }

            stack[num].offerLast(fret);
            count++;
        }
        System.out.println(count);
    }
}
