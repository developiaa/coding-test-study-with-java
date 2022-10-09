package programmers.level2.최솟값_만들기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] A = {1, 4, 2};
//        int[] B = {5, 4, 4}; //29

        int[] A = {1, 2};
        int[] B = {3, 4}; //10
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * B[B.length - i - 1]);
        }
        return sum;
    }
}
