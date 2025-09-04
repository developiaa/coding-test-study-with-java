package baekjoon.graph._2252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int[] inDegree = new int[N + 1];
        int[] check = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            list[src].add(dst);
            inDegree[dst]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            check[now] = 1;
            System.out.print(now + " ");
            for (int next : list[now]) {
                if (check[next] == 1)
                    continue;
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.offer(next);
            }
        }
    }
}
