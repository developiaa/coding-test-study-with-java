package basic.Fibonacci;

public class Fibonacci5 {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int n) {
        long[] mem = new long[n + 1];
        mem[0] = 0;
        mem[1] = 1;

        for (int i = 0; i <= n - 1; i++) {
            mem[i + 1] += mem[i];
            if (i + 2 < mem.length) {
                mem[i + 2] += mem[i];
            }
        }
        return mem[n];
    }
}
