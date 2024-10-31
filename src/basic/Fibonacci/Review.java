package basic.Fibonacci;

public class Review {
    public static void main(String[] args) {
        int n = 40; //102334155
        System.out.println(fibonacci(n));
        System.out.println(calls);
        calls = 0;
        System.out.println();
        System.out.println(fibonacci2(n));
        System.out.println(calls);
        calls = 0;
        System.out.println();
        System.out.println(fibonacci3(n));
        System.out.println(calls);
    }

    public static int[] mem = new int[100];
    public static int calls = 0;

    public static int fibonacci(int n) {
        calls++;
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacci2(int n) {
        calls++;
        if (n == 0 || n == 1) return n;
        if (mem[n] != 0) return mem[n];

        return mem[n] = fibonacci2(n - 1) + fibonacci2(n - 2);
    }

    public static int fibonacci3(int n) {
        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;

        for (int i = 0; i <= n - 1; i++) {
            mem[i + 1] += mem[i];
            if (i + 2 < mem.length) {
                mem[i + 2] += mem[i];
            }
            calls++;
        }
        return mem[n];
    }



}
