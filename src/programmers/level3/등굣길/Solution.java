package programmers.level3.등굣길;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}}; // 4
        System.out.println(solution(m, n, puddles));
    }

    public final static int[][] mem = new int[101][101];

    public static int solution(int m, int n, int[][] puddles) {
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
        return count(1, 1, m, n, isPuddle);
    }

    public static int count(int x, int y, int w, int h, boolean[][] isPuddle) {
        if (x > w || y > h) return 0;
        if (isPuddle[y][x]) return 0;
        if (mem[x][y] != -1) return mem[x][y];
        if (x == w && y == h) return 1;

        int total = count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle);
        return mem[x][y] = total % 1_000_000_007;
    }
}
