package baekjoon.priorityqueue._1655;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
//            if (i % 2 == 0) {
//                left.add(num);
//            } else {
//                right.add(num);
//            }

            if (left.size() == right.size()) {
                left.add(num);
            } else {
                right.add(num);
            }

            if (!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
                Integer big = left.poll();
                Integer small = right.poll();
                left.add(small);
                right.add(big);
            }

            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
