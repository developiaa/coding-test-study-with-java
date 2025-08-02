package baekjoon.queue._5430;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            char[] cmds = sc.next().toCharArray();
            int N = sc.nextInt();
            StringTokenizer st = new StringTokenizer(sc.next(), "[,]");
            Deque<String> dq = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                dq.offer(st.nextToken());
            }

            boolean isFlipped = false;
            boolean isValid = true;

            for (char cmd : cmds) {
                if (cmd == 'D') {
                    if (dq.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (isFlipped) dq.pollLast();
                    else dq.pollFirst();
                } else isFlipped = !isFlipped;
            }

            if (isValid) {
                StringBuilder sb = new StringBuilder();
                while (!dq.isEmpty()) {
                    sb.append(isFlipped ? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()) sb.append(",");
                }
                System.out.println("[" + sb + "]");
            } else {
                System.out.println("error");
            }
        }
    }
}
