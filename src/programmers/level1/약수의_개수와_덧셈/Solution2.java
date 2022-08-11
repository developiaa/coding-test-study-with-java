package programmers.level1.약수의_개수와_덧셈;

public class Solution2 {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        // 43
        System.out.println(solution(left, right));
    }

    public static int solution(int left, int right) {
        int total = 0;
        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) {
                // 제곱수인 경우 약수의 갯수가 홀수
                total -= i;
            } else {
                // 제곱수가 아닌 경우 약수의 갯수가 짝수
                total += i;
            }
        }
        return total;
    }

}
