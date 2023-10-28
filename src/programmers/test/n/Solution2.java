package programmers.test.n;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int[] A = {8,9};
        int[] B = {5,6,7,8};
//        int[] A = {1,3,2,1};
//        int[] B = {4,2,5,3,2};
        System.out.println(solution(A,B));
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
                k = 0; // 이 부분이 추가 되어야 함
            }

            if (A[k] == B[i]) {
                return A[k];
            }
        }
        return -1;
    }
}
