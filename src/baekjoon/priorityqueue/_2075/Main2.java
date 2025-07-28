package baekjoon.priorityqueue._2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // int[] {값, 행, 열} 을 저장할 우선순위 큐 (최대 힙)
        // 값(arr[0])을 기준으로 내림차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 맨 마지막 행의 N개 숫자를 우선순위 큐에 넣는다.
        for (int j = 0; j < N; j++) {
            pq.add(new int[]{grid[N - 1][j], N - 1, j});
        }

        // 2. N-1번 반복하여 가장 큰 수를 빼고, 그 위 칸의 수를 다시 넣는다.
        for (int i = 0; i < N - 1; i++) {
            int[] current = pq.poll(); // 현재 가장 큰 값
            int row = current[1];
            int col = current[2];

            // 바로 위 칸이 존재하면 큐에 추가
            if (row > 0) {
                pq.add(new int[]{grid[row - 1][col], row - 1, col});
            }
        }

        // 3. N-1번 반복 후, 큐의 top에 있는 값이 N번째 큰 수이다.
        System.out.println(pq.peek()[0]);
    }
}
