package basic.nTest;

import java.util.Arrays;

public class example4 {
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 1};
//        int[] A = {1, 1, 1, 1, 5};
        int[] B = {4, 2, 5, 3, 2};

        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;

        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k]) {
                i += 1;
                k = 0; // here
            }

            if (A[k] == B[i]) {
                return A[k];
            }

        }
        return -1;

    }
}
