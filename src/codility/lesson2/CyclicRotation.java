package codility.lesson2;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        System.out.println(Arrays.toString(solution(A, K)));
    }

    public static int[] solution(int[] A, int K) {
        // A 배열의 길이로 나눈 나머지의 인덱스 배열로 가면 됨
        int[] returnArr = A.clone();

        for (int i = 0; i < A.length; i++) {
            System.out.println((i + K) % A.length + ", " + A[i]);

            returnArr[(i + K) % A.length] = A[i];
        }
        return returnArr;
    }

}
