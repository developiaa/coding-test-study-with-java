package programmers.level1.x만큼_간격이_있는_n개의_숫자;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int x = 2;
//        int n = 5;
        // [2,4,6,8,10]

        int x = -4;
        int n = 2;
        // [-4, -8]


        System.out.println(Arrays.toString(solution(x, n)));
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (long) x * i;
        }
        return answer;
    }
}
