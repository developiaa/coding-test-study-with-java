package programmers.level2.멀리_뛰기;

public class Solution {
    public static void main(String[] args) {
        int n = 4; //5
//        int n = 3; //3
        System.out.println(solution(n));
    }

    public static long solution(int n) {
        long[] answer = new long[n + 2];
        answer[0] = 0;
        answer[1] = 1;
        answer[2] = 2;
        for (int i = 3; i <= n; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
        }
        return answer[n];
    }


}
