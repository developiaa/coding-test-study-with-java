package programmers.level1.콜라_문제;

public class Solution {
    public static void main(String[] args) {
//        int a = 2;
//        int b = 1;
//        int n = 20; //19
//        int a = 3;
//        int b = 1;
//        int n = 20; //9
        int a = 4;
        int b = 2;
        int n = 6; // 2+2
        System.out.println(solution(a, b, n));
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;
        int i = 0;
        while (n >= a) {
            i = (n / a) * b;
            answer += i;

            n = (n / a) * b + n % a;
        }
        return answer;
    }
}
