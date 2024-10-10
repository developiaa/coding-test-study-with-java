package programmers.level1.자연수_뒤집어_배열로_만들기;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(long n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int[] answer = new int[charArray.length];
        int index = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            answer[index] = charArray[i] - '0';
            index++;
        }

        return answer;
    }
}
