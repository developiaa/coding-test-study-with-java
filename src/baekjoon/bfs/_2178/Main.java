package baekjoon.bfs._2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = line.charAt(j - 1) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        visited[1][1] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.x + dr[i];
                int nc = now.y + dc[i];
                if (nr <= 0 || nr > N || nc <= 0 || nc > M) continue;

                if (visited[nr][nc] == 0 && arr[nr][nc] == 1) {
                    visited[nr][nc] = visited[now.x][now.y] + 1;
                    queue.add(new Point(nr, nc));
                }
            }
        }

        System.out.println(visited[N][M]);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
