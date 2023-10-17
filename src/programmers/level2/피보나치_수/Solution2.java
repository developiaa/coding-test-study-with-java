package programmers.level2.피보나치_수;

import java.util.Arrays;

public class Solution2 {
    public static int[] mem = new int[100001];
    public static int count = 0;

    public static void main(String[] args) {
//        int n = 3; //2
//        int n = 5; //5
        int n = 10000;

        System.out.println(solution(n));
        System.out.println(count);
    }

    public static int solution(int n) {
        Arrays.fill(mem, -1);
//        for (int i = 0; i <= n; i++) {
//            fibonacci(n);
//        }
        return fibonacci(n);
    }

    public static int fibonacci(int n) {
        count++;
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }
}
