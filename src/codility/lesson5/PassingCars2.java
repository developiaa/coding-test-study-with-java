package codility.lesson5;

//50%...
public class PassingCars2 {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 1}; // 5
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                for (int temp = i; temp < A.length; temp++) {
                    if (A[temp] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;

    }
}
