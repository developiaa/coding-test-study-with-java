package codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree3 {
    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6}; //60
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int max = Integer.MIN_VALUE;

        if (A[0] < 0 && A[1] < 0) {
            max = A[0] * A[1] * A[A.length - 1];
        }

        if (max < (A[A.length - 1] * A[A.length - 2] * A[A.length - 3])) {
            return A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        }
        return max;
    }
}
