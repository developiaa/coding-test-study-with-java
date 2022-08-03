package programmers.level1.약수의_합;

public class Solution {
    public static void main(String[] args) {
        // 28
        System.out.println(solution(12));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += n / i;
            }
        }

        return answer;
    }
}
