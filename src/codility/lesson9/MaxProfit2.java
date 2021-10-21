package codility.lesson9;

public class MaxProfit2 {
    public static void main(String[] args) {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if (A.length == 0 || A.length == 1) return 0;
        int min = A[0];
        int localProfit = 0;
        int maxProfit = 0;

        for (int i = 1; i < A.length; i++) {
            localProfit = A[i] - min;
            if (A[i] < min) {
                min = A[i];
            }

            maxProfit = Math.max(localProfit, maxProfit);
        }
        if (maxProfit < 0) return 0;

        return maxProfit;

    }
}
