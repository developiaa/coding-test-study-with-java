package codility.lesson4;

import java.util.Arrays;

//77%
//large_random2 timeout error
public class MaxCounters {
    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(solution(N, A));
    }

    public static int[] solution(int N, int[] A) {
        int[] returnArr = new int[N];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                returnArr[A[i] - 1]++;
                if (max < returnArr[A[i] - 1]) {
                    max = returnArr[A[i] - 1];
                }
            } else {
                if (A[i] == N + 1) {
                    Arrays.fill(returnArr, max);
                }
            }

            System.out.println(i + ", " + Arrays.toString(returnArr));
        }


        return returnArr;
    }
}
