package codility.lesson6;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int N = A.length;
        if (N < 3) return 0;

        Arrays.sort(A);

        for (int i = 0; i < N - 2; i++) {
            //무조건 연속된 숫자일수밖에없음
            long P = A[i], Q = A[i + 1], R = A[i + 2];
            //정렬을 했기 때문에 3가지 조건이 아닌 1가지만 맞으면 됨
            if (P + Q > R) return 1;
        }
        return 0;
    }
}
