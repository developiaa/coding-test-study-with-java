package codility.lesson3;

public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int diff = 0;
        int part = 0;

        int min = Math.abs(A[0] - (sum-A[0]));
        for (int i = 0; i < A.length-1; i++) {
            part += A[i];
            diff = Math.abs(part - (sum - part));
            System.out.println("diff = " + diff);
            if (min > diff) {
                min = diff;
            }
        }
        return min;

    }
}
