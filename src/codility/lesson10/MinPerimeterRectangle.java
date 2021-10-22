package codility.lesson10;

public class MinPerimeterRectangle {
    public static void main(String[] args) {
        int N = 36;
        System.out.println(solution(N));
    }

    public static int solution(int N) {
        if (N % Math.sqrt(N) == 0) {
            return 2 * 2 * (int) (N / Math.sqrt(N));
        }

        int max = 0;
        for (int i = 1; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                if (max < i) {
                    max = i;

                }
            }
        }
        int other = N / max;
        return 2 * (other + max);
    }

}
