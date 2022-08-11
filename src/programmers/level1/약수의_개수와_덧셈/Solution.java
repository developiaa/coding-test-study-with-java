package programmers.level1.약수의_개수와_덧셈;

public class Solution {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        // 43
        System.out.println(solution(left, right));
    }

    public static int solution(int left, int right) {
        int total = 0;
        for (int i = left; i <= right; i++) {
            int num = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    num++;
                }
            }

            if (num % 2 == 0) {
                // 짝수인 경우
                total += i;
            } else {
                // 홀수인 경우
                total -= i;
            }
        }
        return total;
    }

}
