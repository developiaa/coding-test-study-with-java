package baekjoon.bfs._5427;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] fire = new int[m][n];
            int[][] visited = new int[m][n];

            Queue<Point> q = new LinkedList<>();
            Queue<Point> fireQ = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                String line = sc.next();
                for (int j = 0; j < n; j++) {
                    char c = line.charAt(j);
                    if (c == '#') {
                        fire[i][j] = visited[i][j] = -1;
                    } else if (c == '@') {
                        q.add(new Point(i, j));
                        visited[i][j] = 1;
                    } else if (c == '*') {
                        fireQ.add(new Point(i, j));
                        fire[i][j] = 1;
                    }
                }
            }

            // 불 먼저 확인
            while (!fireQ.isEmpty()) {
                Point now = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (fire[nr][nc] == 0) {
                        fire[nr][nc] = fire[now.r][now.c] + 1;
                        fireQ.add(new Point(nr, nc));
                    }
                }
            }

            boolean isEscaped = false;
            while (!q.isEmpty()) {
                Point now = q.poll();
                if (now.r == 0 || now.r == m - 1 || now.c == 0 || now.c == n - 1) {
                    System.out.println(visited[now.r][now.c]);
                    isEscaped = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (visited[nr][nc] != 0) continue;
                    if (fire[nr][nc] == 0 || fire[nr][nc] > visited[now.r][now.c] + 1) {
                        visited[nr][nc] = visited[now.r][now.c] + 1;
                        q.add(new Point(nr, nc));
                    }
                }
            }

            if (!isEscaped) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

