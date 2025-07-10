package baekjoon.graph._11724;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

//        for (int i = 1; i <= n; i++) {
//            if (!visited[i]) {
//                dfsRecursion(i);
//                cnt++;˛
//            }
//        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void dfs(int node) {
        Stack<Integer> s = new Stack<>();
        s.push(node);
        visited[node] = true;

        while (!s.empty()) {
            int now = s.pop();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    s.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    // 재귀를 이용한 dfs
    static void dfsRecursion(int node) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfsRecursion(i);
            }
        }
    }
}
