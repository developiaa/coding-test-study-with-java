package codility.lesson4;

import java.util.Arrays;

//77%
//large_random2 timeout error
public class MaxCounters2 {
    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(solution(N, A)));
    }

    public static int[] solution(int N, int[] A) {
        int[] returnArr = new int[N];
        int max = 0;
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) {
                max = temp;
                continue;
            }

            if (returnArr[A[i] - 1] < max) {
                returnArr[A[i] - 1] = max;
            }

            returnArr[A[i] - 1]++;

            if (returnArr[A[i] - 1] > temp) {
                temp = returnArr[A[i] - 1];
            }
        }

        for (int i = 0; i < returnArr.length; i++) {
            if (returnArr[i] < max) {
                returnArr[i] = max;
            }
        }


        return returnArr;
    }
}
