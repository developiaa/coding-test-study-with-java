package programmers.level3.정수_삼각형;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; // 30
        System.out.println(solution(triangle));
    }

    public final static int[][] mem = new int[501][501];

    public static int solution(int[][] triangle) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return max(0, 0, triangle);
    }

    public static int max(int x, int y, int[][] triangle) {
        if (y == triangle.length) return 0;
        if (mem[x][y] != -1) return mem[x][y];
        return mem[x][y] = triangle[y][x] + Math.max(
                max(x, y + 1, triangle),
                max(x + 1, y + 1, triangle)
        );
    }
}
