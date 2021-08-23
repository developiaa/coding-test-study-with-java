package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//        5
//        0 0 0 0 0
//        0 1 1 1 1
//        0 0 0 0 0
//        1 1 1 1 0
//        0 0 0 0 0
//        0 1 4 2
public class bfs {
    static final int MAX_N = 10;
    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int[][] Board = new int[MAX_N][MAX_N];

    static class Point {
        Point(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }

        int row, col, dist;
    }

    static int bfs(int sRow, int sCol, int dRow, int dCol) {
        boolean[][] visited = new boolean[MAX_N][MAX_N];
        Queue<Point> queue = new LinkedList<>();
        visited[sRow][sCol] = true;
        queue.add(new Point(sRow, sCol, 0));


        while (!queue.isEmpty()) {
            Point curr = queue.remove();
            if (curr.row == dRow && curr.col == dCol) {
                return curr.dist;
            }

            for (int i = 0; i < 4; ++i) {
                int nr = curr.row + D[i][0];
                int nc = curr.col + D[i][1];

                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) continue;
                if (visited[nr][nc]) continue;
                if (Board[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                queue.add(new Point(nr, nc, curr.dist + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Board[i][j] = s.nextInt();
            }
        }

        int sRow, sCol, dRow, dCol;
        sRow = s.nextInt();
        sCol = s.nextInt();
        dRow = s.nextInt();
        dCol = s.nextInt();
        System.out.println(bfs(sRow, sCol, dRow, dCol));

    }
}
