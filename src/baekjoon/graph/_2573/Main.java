package baekjoon.graph._2573;

import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};
    static List<Ice> iceList;

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

        // 시간이 흐를때마다 빙산 녹이기
        for (int year = 1; !iceList.isEmpty(); year++) {
            for (Ice ice : iceList) {
                for (int j = 0; j < 4; j++) {
                    int nr = ice.x + dr[j];
                    int nc = ice.y + dc[j];
                    if (arr[nr][nc] == 0) ice.height--;
                }
            }

            // 녹은 빙산들의 높이를 한번에 갱신
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) {
                    arr[ice.x][ice.y] = 0;
                    iceList.set(i, iceList.get(iceList.size() - 1));
                    iceList.removeLast();
                    i--;
                } else {
                    // 빙산이 남아 있다면 연결되어 있는지 탐색하도록 세팅
                    visited[ice.x][ice.y] = false;
                }
            }

            if (iceList.size() > 0 && dfs(iceList.get(0).x, iceList.get(0).y) != iceList.size()) {
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
        int x;
        int y;
        int height;

        public Ice(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
