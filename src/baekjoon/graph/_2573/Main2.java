package baekjoon.graph._2573;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static List<Ice> iceList;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        iceList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > 0) {
                    iceList.add(new Ice(i, j, arr[i][j]));
                }
                visited[i][j] = true;
            }
        }

        for (int year = 1; !iceList.isEmpty(); year++) {
            for (Ice ice : iceList) {
                for (int i = 0; i < 4; i++) {
                    int nr = ice.row + dr[i];
                    int nc = ice.col + dc[i];
                    if (arr[nr][nc] == 0) ice.height--;
                }
            }

            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) {
                    arr[ice.row][ice.col] = 0;
                    iceList.set(i, iceList.get(iceList.size() - 1));
                    iceList.remove(iceList.size() - 1);
                    i--;
                } else {
                    visited[ice.row][ice.col] = false;
                }
            }

            if (iceList.size() > 0 && dfs(iceList.get(0).row, iceList.get(0).col) != iceList.size()) {
                System.out.println(year);
                System.exit(0);
            }
        }
        System.out.println(0);

    }

    static int dfs(int r, int c) {
        visited[r][c] = true;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (visited[nr][nc]) continue;
            cnt += dfs(nr, nc);
        }
        return cnt;
    }

    static class Ice {
        int row;
        int col;
        int height;

        public Ice(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
