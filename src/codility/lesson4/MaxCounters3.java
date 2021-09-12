package codility.lesson4;

import java.util.Arrays;

public class MaxCounters3 {
    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(solution(N, A)));
    }

    public static int[] solution(int N, int[] A) {
        int[] returnArr = new int[N];
        //max counter시 사용되는 값
        int max = 0;

        //현재 가진 값중에서 가장 큰 값
        int temp = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                max = temp;
                continue;
            }
            // 1번이상 업데이트 되지만 max counter의 영향을 받아야 하는 경우에 호출
            if (returnArr[A[i] - 1] < max) {
                returnArr[A[i] - 1] = max;
            }

            if (A[i] <= N) {
                returnArr[A[i] - 1]++;

                if (temp < returnArr[A[i] - 1]) {
                    temp = returnArr[A[i] - 1];
                }
            }
        }
        System.out.println(Arrays.toString(returnArr));
        System.out.println("--------------");
        // 한번도 업데이트 안된 값의 경우만 max counter
        for (int i = 0; i < returnArr.length; i++) {
            if (returnArr[i] < max) {
                returnArr[i] = max;
            }
        }
        return returnArr;
    }
}
