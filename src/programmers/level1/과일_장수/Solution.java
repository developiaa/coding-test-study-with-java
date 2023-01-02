package programmers.level1.과일_장수;

import java.util.Arrays;

public class Solution {
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
        if (score.length < m) {
            return 0;
        }
        Arrays.sort(score);
        int count = 0;
        int num = 1;
        int min = k;
        for (int i = score.length - 1; i >= 0; i--) {
            if (score[i] < min) {
                min = score[i];
            }
            if (num >= m) {
                count += min * m;
                num = 1;
                min = k;
                continue;
            }
            num++;
        }
        return count;
    }
}
