package programmers.level2.삼각_달팽이;

import java.util.Arrays;

public class Solution_review {
    public static void main(String[] args) {
        int n = 4; // {1,2,9,3,10,8,4,5,6,7}
//        int n = 5; // {1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}
//        int n = 6; // {1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11}
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;

        int x = 0;
        int y = 0;

        while (true) {
            // 아래로 이동
            while (true) {
                triangle[y][x] = v++;
                if (y + 1 == n || triangle[y + 1][x] != 0) break;
                y += 1;
            }
            if (x + 1 == n || triangle[y][x + 1] != 0) break;
            x += 1;

            // 오른족으로 이동
            while (true) {
                triangle[y][x] = v++;
                if (x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;
            }
            if (triangle[y - 1][x - 1] != 0) break;
            y -= 1;
            x -= 1;

            // 왼쪽 위로 이동
            while (true) {
                triangle[y][x] = v++;
                if (triangle[y - 1][x - 1] != 0) break;
                y -= 1;
                x -= 1;
            }
            if(y+1==n|| triangle[y+1][x]!=0) break;
            y += 1;

        }

        for (int[] ints : triangle) {
            System.out.println(Arrays.toString(ints));
        }

        int[] answer = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index] = triangle[i][j];
                index++;
            }
        }

        return answer;
    }
}
