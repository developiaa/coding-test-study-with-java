package baekjoon.bfs._1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[100_001];
        queue.add(N);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == K) break;
            int[] next = {now + 1, now - 1, now * 2};
            for (int i = 0; i < 3; i++) {
                if (!isRange(next[i])) continue;
                if (visited[next[i]] == 0) {
                    visited[next[i]] = visited[now] + 1;
                    queue.add(next[i]);
                }
            }
        }

        System.out.println(visited[K]);
    }

    static boolean isRange(int n) {
        return n >= 0 && n <= 100_000;
    }
}
