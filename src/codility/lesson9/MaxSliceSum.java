package codility.lesson9;

public class MaxSliceSum {
    public static void main(String[] args) {
//        int[] A = {3, 2, -6, 4, 0}; //5
//        int[] A = {3, 2, -6, 7, 0}; //7
//        int[] A = {-3, 2, -6, 4, 0}; //4
        int[] A = {3, 4, -6, 7, 0}; //8
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if (A.length == 1) return A[0];

        int localSum = A[0];
        int maxSum = A[0];

        for (int i = 1; i < A.length; i++) {
            localSum = Math.max(A[i], localSum + A[i]);
            maxSum = Math.max(localSum, maxSum);
        }

        return maxSum;
    }

}
