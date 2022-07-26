package programmers.level1.모의고사;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
//        int[] answer = {1, 2, 3, 4, 5}; // {1}
        int[] answer = {1, 3, 2, 4, 2}; // {1,2,3}
        System.out.println(Arrays.toString(solution(answer)));
    }

    public static int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] answer = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (a[i % a.length] == answers[i]) {
                answer[0]++;
            }
            if (b[i % b.length] == answers[i]) {
                answer[1]++;
            }
            if (c[i % c.length] == answers[i]) {
                answer[2]++;
            }
        }
        int maxScore = Math.max(answer[0], Math.max(answer[1], answer[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if (maxScore == answer[0]) {
            list.add(1);
        }
        if (maxScore == answer[1]) {
            list.add(2);
        }
        if (maxScore == answer[2]) {
            list.add(3);
        }

        // 훨씬 빠름
        int[] score = new int[list.size()];
        for (int i = 0; i < score.length; i++) {
            score[i] = list.get(i);
        }

        return score;
    }
}
