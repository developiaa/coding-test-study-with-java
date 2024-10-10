package programmers.level1.모의고사;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution3_review {
    public static void main(String[] args) {
//        int[] answer = {1, 2, 3, 4, 5}; // {1}
        int[] answer = {1, 3, 2, 4, 2}; // {1,2,3}
        System.out.println(Arrays.toString(solution(answer)));
    }

    private static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public static int[] solution(int[] answers) {
        int[] result = new int[RULES.length];
        int max = 0;
        for (int i = 0
             ; i < answers.length; i++) {
            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, i);
                if (answers[i] == picked) {
                    if (++result[person] > max) {
                        max = result[person];
                    }
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> result[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();

    }

    private static int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }

}
