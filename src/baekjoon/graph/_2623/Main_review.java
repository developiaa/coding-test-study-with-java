package baekjoon.graph._2623;

import java.util.*;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int num = sc.nextInt();
            int first = sc.nextInt();

            for (int j = 0; j <= num - 2; j++) {
                int second = sc.nextInt();
                list[first].add(second);
                inDegree[second]++;
                first = second;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n + 1];

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            check[now] = true;
            answer.add(now);

            if (list[now].size() > n) {
                System.out.println(0);
                return;
            }

            for (Integer next : list[now]) {
                if(check[next]) continue;
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                System.out.println(0);
                return;
            }
        }

        for (Integer i : answer) {
            System.out.println(i);
        }
    }
}
