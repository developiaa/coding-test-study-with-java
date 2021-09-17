package codility.lesson5;

//쉬운 예제 풀이
//그렇기 때문에 performance 0%
public class CountDiv {
    public static void main(String[] args) {
        int A=6;
        int B=11;
        int K=2;
        System.out.println(solution(A, B, K));
    }

    public static int solution(int A, int B, int K) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                count++;
            }
        }
        return count;
    }
}
