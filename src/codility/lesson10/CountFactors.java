package codility.lesson10;

public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solution(24));
    }

    public static int solution(int N) {
        if (N == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                count++;
            }
        }
        count = 2 * count;
        if (N % Math.sqrt(N) == 0) {
            count += 1;
        }

        return count;
    }
}
