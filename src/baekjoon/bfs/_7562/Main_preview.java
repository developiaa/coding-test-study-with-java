package baekjoon.bfs._7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] visited = new int[n][n];
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(sc.nextInt(), sc.nextInt()));
            int lastX = sc.nextInt();
            int lastY = sc.nextInt();

            while (!queue.isEmpty()) {
                Point now = queue.poll();
                if (now.x == lastX && now.y == lastY) {
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int r = now.x + dr[i];
                    int c = now.y + dc[i];
                    if (!isRange(r, c, n)) continue;
                    if (visited[r][c] == 0) {
                        visited[r][c] = visited[now.x][now.y] + 1;
                        queue.add(new Point(r, c));
                    }
                }
            }

            System.out.println(visited[lastX][lastY]);
        }
    }

    static boolean isRange(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
