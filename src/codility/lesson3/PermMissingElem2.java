package codility.lesson3;


public class PermMissingElem2 {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int sum = 0;
        for (int i = 0; i <= A.length + 1; i++) {
            sum += i;
        }

        for (int i = 0; i < A.length; i++) {
            sum -= A[i];
        }

        return sum;
    }
}
