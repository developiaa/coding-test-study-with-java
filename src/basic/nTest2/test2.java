package basic.nTest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
public class test2 {
    public static void main(String[] args) {
        int[] A = {6, 1, 4, 6, 3, 2, 7, 4};
//        int[] A = {10, 19, 15};
        int K = 3;
        int L = 2; //24
        System.out.println(solution(A, K, L));
    }

    public static int solution(int[] A, int K, int L) {
        if (A.length < K + L) {
            return -1;
        }

        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int a = i;
            int sumA = 0;
            int sumB = 0;
            for (a = i; a < K; a++) {
                if (i + K < A.length) {
                    sumA += A[a];
                }
            }
//            System.out.println("sumA = " + sumA);

            for (int b = K; b <= K + L; b++) {
                sumB += A[b];
//                System.out.println("sumB = " + sumB);
                list.add(sumA + sumB);
            }

        }
        System.out.println("list = " + list);

        return Collections.max(list);

    }
}
