package codility.lesson12;

public class ChocolatesByNumbers {
    public static void main(String[] args) {
        int N = 24;
        int M = 18;
        System.out.println(solution(N, M));
    }

    /**
     * 정확하지만 퍼포먼스가 낮다 (O(n))
     *
     * @param N
     * @param M
     * @return
     */
//    public static int solution(int N, int M) {
//        if (N == 1) return 1;
//        int i = 1;
//        int count = 1;
//        while (true) {
//            if ((i * M) % N == 0) {
//                break;
//            }
//            i++;
//            count++;
//        }
//        return count;
//    }

    /**
     * log(N+M) 유클리드 호제법
     * @param N
     * @param M
     * @return
     */
    public static int solution(int N, int M) {
        if (N == 1) return 1;
        int gcd = gcd(N, M);
        return N / gcd;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
