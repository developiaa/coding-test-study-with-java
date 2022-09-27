package programmers.level2.피보나치_수;

public class Solution {
    public static void main(String[] args) {
//        int n = 3; //2
//        int n = 5; //5
//        int n = 10000;
        int n = 100000;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int a = 0;
        int b = 1;
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
        return answer;
    }
}
