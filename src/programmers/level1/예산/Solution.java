package programmers.level1.예산;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] d = {1, 3, 2, 5, 4};
//        int budget = 9; //3

        int[] d = {2,2,3,3};
        int budget = 10; //4
        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if (budget < 0) {
                return count;
            }
            count++;
        }
        return count;
    }
}
