package programmers.level1.명예의_전당;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int k = 3;
//        int[] score = {10, 100, 20, 150, 1, 100, 200}; // [10, 10, 10, 20, 20, 100, 100]
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}; // [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
        System.out.println(Arrays.toString(solution(k, score)));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int min = 2001;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
            Collections.sort(list);
            if (i + 1 <= k) {
                if (score[i] < min) {
                    min = score[i];
                }
                answer[i] = min;
            } else {
                answer[i] = list.get(i - k + 1);
            }
        }
        return answer;
    }
}
