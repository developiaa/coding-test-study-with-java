package programmers.level1.과일_장수;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
//        int k = 3;
//        int m = 4;
//        int[] score = {1, 2, 3, 1, 2, 3, 1}; // 8
//        int k = 4;
//        int m = 3;
//        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}; // 33
        int k = 4;
        int m = 3;
        int[] score = {1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4}; // 30
        System.out.println(solution(k, m, score));
    }

    public static int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int count = 0;
        for (int i = score.length; i >= m; i -= m) {
            count += score[i - m] * m;
        }
        return count;
    }
}
