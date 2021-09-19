package codility.lesson6;

//역시 44%
public class MaxProductOfThree2 {
    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6}; //60
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int q = 1;
        int r = 2;
        int N = A.length;

        int max = Integer.MIN_VALUE;
        for (int p = 0; p < A.length; p++) {
            int temp = Integer.MIN_VALUE;
            q = p + 1;
            r = q + 1;
            for (q = p + 1; q < A.length; q++) {
                for (r = q + 1; r < A.length; r++) {
                    temp = A[p] * A[q] * A[r];
                    System.out.println(p + ", " + q + ", " + r + ", " + temp);
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }
}
