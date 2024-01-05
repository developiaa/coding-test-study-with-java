package programmers.test.n2412;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
//        int[] P = {1, 4, 1};
//        int[] S = {1, 5, 1}; // 2

//        int[] P = {4, 4, 2, 4};
//        int[] S = {5, 5, 2, 5}; // 3

        int[] P = {2, 3, 4, 2};
        int[] S = {2, 5, 7, 2}; // 2

        System.out.println(solution(P, S));
    }

    public static int solution(int[] P, int[] S) {
        int total = 0;
        for (int i : P) {
            total += i;
        }

        Arrays.sort(S);

        int answer = 0;
        int max = 0;
        for (int i = S.length - 1; i >= 0; i--) {
            max += S[i];
            answer++;
            if (max >= total) {
                break;
            }
        }

        return answer;
    }
}
