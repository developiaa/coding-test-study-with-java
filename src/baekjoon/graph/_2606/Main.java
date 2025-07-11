package baekjoon.graph._2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int v, e;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        graph = new int[v + 1][v + 1];
        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        dfs(1);
        System.out.println(cnt - 1);


        cnt = 0;
        visited = new boolean[v + 1];
        bfs(1);
        System.out.println(cnt - 1);
    }

    static void dfs(int node) {
        visited[node] = true;
        cnt++;
        for (int i = 1; i <= v; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }


    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            for (int i = 1; i <= v; i++) {
                if (graph[cur][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
