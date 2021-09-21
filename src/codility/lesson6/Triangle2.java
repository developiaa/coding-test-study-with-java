package codility.lesson6;

import java.util.Arrays;

public class Triangle2 {
    public static void main(String[] args) {
//        int[] A = {10, 2, 5, 1, 8, 20}; //1
//        int[] A = {10,50,5,1}; //0
        int[] A = {-2147483648, -2147483647, -2147483641};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        for (int i = 0; i < A.length - 2; i++) {
            long temp = A[i];
            long temp1 = A[i + 1];
            long temp2 = A[i + 2];
            if (temp + temp1 > temp2) {
                return 1;
            }
        }
        return 0;
    }
}
