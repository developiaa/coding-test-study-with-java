package programmers.level2.삼각_달팽이;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int n = 4; // {1,2,9,3,10,8,4,5,6,7}
//        int n = 5; // {1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}
//        int n = 6; // {1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11}
        System.out.println(Arrays.toString(solution(n)));
    }

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public static int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1; // 채워넣을 숫자

        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }
}
