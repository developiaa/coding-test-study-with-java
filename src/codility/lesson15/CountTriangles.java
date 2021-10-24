package codility.lesson15;

public class CountTriangles {
    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 12}; //4
        System.out.println(solution(A));
    }

    //correct 100% perfo 0%
    public static int solution(int[] A) {
        int count=0;
        for (int p = 0; p < A.length - 2; p++) {
            for (int q = p + 1; q < A.length - 1; q++) {
                for (int r = q + 1; r < A.length; r++) {
                    if (A[p] + A[q] > A[r] && A[q] + A[r] > A[p] && A[r] + A[p] > A[q]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
