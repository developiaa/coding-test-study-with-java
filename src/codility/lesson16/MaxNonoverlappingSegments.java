package codility.lesson16;

public class MaxNonoverlappingSegments {
    public static void main(String[] args) {
        int[] A = {1, 3, 7, 9, 9};
        int[] B = {5, 6, 8, 9, 10};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }

        int count = 1;
        int some = B[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] > some) {
                count++;
                some = B[i];
            }
        }

        return count;
    }
}
