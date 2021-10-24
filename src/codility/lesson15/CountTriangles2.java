package codility.lesson15;

import java.util.Arrays;

public class CountTriangles2 {
    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 12}; //4
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int count = 0;
        /**
         * 정렬을 하게되는 경우
         * p<q<r일 때 A[p] + A[q] > A[r]을 만족할 수 있게 된다.
         */
        Arrays.sort(A);
        for (int p = 0; p < A.length - 2; p++) {
            int q = p + 1;
            int r = q + 1;

            while (q < A.length - 1) {
                if (r < A.length && A[p] + A[q] > A[r]) {
                    r++;
                } else {
                    count += (r - q - 1);
                    q++;
                }
            }
        }

        return count;
    }
}
