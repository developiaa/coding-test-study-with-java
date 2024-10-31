package programmers.level3.정수_삼각형;

import java.util.Arrays;

public class Review {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; // 30
        System.out.println(solution(triangle));
    }

    public static int[][] sum = new int[501][501];

    public static int solution(int[][] triangle) {
//        return max(0, 0, triangle);

        for (int[] ints : sum) {
            Arrays.fill(ints, -1);
        }
        return max2(0, 0, triangle);
    }

    // 양이 많아질 경우 시간 제한
    private static int max(int x, int y, int[][] triangle) {
        if (y == triangle.length) return 0;

        return triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x + 1, y + 1, triangle));
    }

    // 메오이제이션 적용
    private static int max2(int x, int y, int[][] triangle) {
        if (y == triangle.length) return 0;
        if (sum[x][y] != -1) return sum[x][y];

        return sum[x][y] = triangle[y][x] + Math.max(max2(x, y + 1, triangle), max2(x + 1, y + 1, triangle));
    }
}
