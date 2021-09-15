package codility.lesson5;


public class PassingCars3 {
    public static void main(String[] args) {
        int[] A = {0, 1, 1, 0, 1}; // 5
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int count = 0;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                sum=sum+1;
            } else {
                count += sum;
            }
        }

        if (count > 1000000000 || count < 0) {
            return -1;
        }


        return count;

    }
}
