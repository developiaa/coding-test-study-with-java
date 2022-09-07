package programmers.level1.자연수_뒤집어_배열로_만들기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        String[] split = s.split("");
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(split[answer.length - i - 1]);
        }
        return answer;
    }
}
