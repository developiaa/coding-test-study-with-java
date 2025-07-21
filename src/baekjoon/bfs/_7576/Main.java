package baekjoon.bfs._7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[N][M];
        visited = new int[N][M];

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    q.add(new Point(i, j));
                    visited[i][j] = 1;
                }
            }
        }


        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (board[nr][nc] == -1) continue;
                if (visited[nr][nc] == 0 && board[nr][nc] == 0) {
                    visited[nr][nc] = visited[now.r][now.c] + 1;
                    q.add(new Point(nr, nc));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, visited[i][j]);
                if (board[i][j] == 0 && visited[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(max - 1);

    }


    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

