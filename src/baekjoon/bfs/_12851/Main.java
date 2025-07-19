package baekjoon.bfs._12851;

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
        int[] count = new int[100_001];
        queue.add(N);
        count[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == K) continue;
            int[] next = {now + 1, now - 1, now * 2};
            for (int i = 0; i < 3; i++) {
                if (!isRange(next[i])) continue;
                if (visited[next[i]] == 0) {
                    visited[next[i]] = visited[now] + 1;
                    count[next[i]] = count[now];
                    queue.add(next[i]);
                } else if (visited[next[i]] == visited[now] + 1) {
                    count[next[i]] += count[now];
                }
            }
        }

        System.out.println(visited[K]);
        System.out.println(count[K]);
    }

    private static boolean isRange(int i) {
        return i >= 0 && i <= 100_000;
    }
}
