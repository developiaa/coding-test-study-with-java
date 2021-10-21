package codility.lesson9;

public class MaxProfit3 {
    public static void main(String[] args) {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if (A.length == 0 || A.length == 1) return 0;

        int min = A[0];

        int k = 0;
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            k = A[i] - min;
            if (A[i] < min) {
                min = A[i];
            }

            if (max < k) {
                max = k;
            }
        }

        if (max < 0) {
            return 0;
        } else {
            return max;
        }
    }

}
