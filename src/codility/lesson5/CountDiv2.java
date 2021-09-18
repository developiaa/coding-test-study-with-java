package codility.lesson5;

public class CountDiv2 {
    public static void main(String[] args) {
        int A = 0;
        int B = 0;
        int K = 10000;
        System.out.println(solution(A, B, K));
    }

    public static int solution(int A, int B, int K) {
        int count = 0;
        if (A % K == 0) count++;
        if (A != B) {
            int first = A / K;
            int second = B / K;
            count += second - first;
        }
        return count;
    }
}
