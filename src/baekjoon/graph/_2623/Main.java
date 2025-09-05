package baekjoon.graph._2623;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[N + 1];
        int[] check = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            int front = sc.nextInt();
            for (int j = 2; j <= num; j++) {
                int back = sc.nextInt();
                list[front].add(back);
                front = back;
                inDegree[back]++;
            }
        }


        // 진입차수가 0인 정점을 넣어준다.
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            check[now] = 1;
            answer.add(now);

            // 사이클인지 확인
            if (answer.size() > N) {
                System.out.println(0);
                return;
            }

            for (int next : list[now]) {
                if (check[next] == 1) {
                    continue;
                }
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (check[i] == 0) {
                System.out.println(0);
                return;
            }
        }

        for (Integer i : answer) {
            System.out.println(i);
        }
    }
}
