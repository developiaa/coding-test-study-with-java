package programmers.level1.자릿수_더하기;

public class Solution {
    public static void main(String[] args) {
//        int n = 123; // 6
        int n = 987; // 24
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
