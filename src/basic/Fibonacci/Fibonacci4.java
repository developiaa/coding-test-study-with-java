package basic.Fibonacci;

import java.util.Arrays;
// 메모이제이션 이용
public class Fibonacci4 {
    public static long[] mem = new long[101];

    public static void main(String[] args) {
        Arrays.fill(mem, -1);
        int n = 100;
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int n) {
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
