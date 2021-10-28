package codility.lesson16;

public class TieRopes {
    public static void main(String[] args) {
        int K = 4;
        int[] A = {1, 2, 3, 4, 1, 1, 3};
        System.out.println(solution(K, A));
    }

    public static int solution(int K, int[] A) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= K) {
                count++;
                sum = 0;
            }
        }
        return count;
    }
}
