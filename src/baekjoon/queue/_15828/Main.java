package baekjoon.queue._15828;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

//        Queue<Integer> q = new LinkedList<>();
//        while (true) {
//            int cmd = sc.nextInt();
//            if (cmd > 0) {
//                if (q.size() < N) {
//                    q.offer(cmd);
//                }
//            } else if (cmd == 0) {
//                q.poll();
//            } else {
//                break;
//            }
//        }
        Queue<Integer> q = new LinkedBlockingQueue<>(N);
        while (true) {
            int cmd = sc.nextInt();
            if (cmd > 0) {
                q.offer(cmd);
            } else if (cmd == 0) {
                q.poll();
            } else {
                break;
            }
        }

        if (q.isEmpty()) {
            System.out.println("empty");
        } else {
            while (!q.isEmpty()) {
                System.out.print(q.poll() + " ");
            }
        }
    }
}
