package baekjoon.graph._11779;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = 1_000_000_000;
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge>[] graph = new List[n + 1];
        int[] cost = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            cost[i] = INF;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            int c = sc.nextInt();
            graph[src].add(new Edge(dst, c));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Edge(start, 0));
        cost[start] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (cost[now.dist] < now.cost) {
                continue;
            }
            for (Edge next : graph[now.dist]) {
                if (cost[now.dist] + next.cost < cost[next.dist]) {
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist]));
                    path[next.dist] = now.dist;
                }
            }
        }
        System.out.println(cost[end]);
        Stack<Integer> stack = new Stack<>();
        int now = end;

        while (now != 0) {
            stack.push(now);
            now = path[now];
        }
        System.out.println(stack.size());

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static class Edge {
        int dist;
        int cost;

        public Edge(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }
}
