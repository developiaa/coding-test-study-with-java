package baekjoon.graph._2252;

import java.util.*;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] list = new ArrayList[n + 1];
        int[] inDegree = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            list[first].add(second);
            inDegree[second]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            check[now] = true;
            System.out.print(now + " ");
            for (Integer i : list[now]) {
                if(check[i]) continue;
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }




    }
}
