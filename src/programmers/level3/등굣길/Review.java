package programmers.level3.등굣길;

import java.util.Arrays;

public class Review {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}}; // 4
        System.out.println(solution(m, n, puddles));
    }


//    public static int solution(int m, int n, int[][] puddles) {
//        boolean[][] isPuddle = new boolean[n + 1][m + 1];
//        for (int[] p : puddles) {
//            isPuddle[p[1]][p[0]] = true;
//        }
//
//        return count(1, 1, m, n, isPuddle);
//    }
//
//    public static int count(int x, int y, int w, int h, boolean[][] isPuddles) {
//        if (x > w || y > h) return 0; // 경로 밖일 경우
//        if (isPuddles[y][x]) return 0; // 웅덩이 케이스
//        if (x == w && y == h) return 1; // 학교에 도착했을 때
//
//        int total = count(x + 1, y, w, h, isPuddles) + count(x, y + 1, w, h, isPuddles);
//        return total % 1_000_000_007;
//    }

    public static int[][] mem = new int[101][101];

    public static int solution(int m, int n, int[][] puddles) {
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }

        boolean[][] visited = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            visited[puddle[1]][puddle[0]] = true;
        }

        return count(1, 1, m, n, visited);
    }

    public static int count(int x, int y, int w, int h, boolean[][] isPuddle) {
        if (x > w || y > h) return 0;
        if (isPuddle[y][x]) return 0;
        if (mem[y][x] != -1) return mem[y][x];
        if (x == w && y == h) return 1;

        mem[y][x] = (count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle)) % 1000000007;
        return mem[y][x];

    }


}
