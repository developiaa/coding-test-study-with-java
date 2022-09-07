package programmers.level1.정수_제곱근_판별;

public class Solution {
    public static void main(String[] args) {
        long n = 1; //144
//        int n = 3; //-1
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        for (long i = 1; i <= n; i++) {
            if (n == i * i) {
                return (i + 1) * (i + 1);
            }
        }
        return -1;
    }
}
