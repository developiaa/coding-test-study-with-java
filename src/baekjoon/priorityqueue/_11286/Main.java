package baekjoon.priorityqueue._11286;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 < o2 ? -1 : 1;
            }
            return Math.abs(o1) < Math.abs(o2) ? -1 : 1;

        });

        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(x);
            }
        }

        System.out.println(sb.toString());
    }
}
