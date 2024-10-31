package basic.Fibonacci;

//재귀 방식으로 해결
public class Fibonacci1 {
    public static void main(String[] args) {
        int n = 40; //102334155
//        int n = 10; //55
        System.out.println(fibonacci(n));

        System.out.println(fibonacci2(n));
        System.out.println(num);

        System.out.println();
        System.out.println(fibonacci3(n));
        System.out.println(num2);

        System.out.println(iterativeFibonacci(n));
    }

    public static int num = 0;
    public static int num2 = 0;
    public static long[] mem = new long[100];

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 위와 동일
    public static long fibonacci2(int n) {
        num++;
        if (n == 0 || n == 1) return n;
        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }

    // 메오이제이션 - 중복해서 계산하는 값을 줄임
    public static long fibonacci3(int n) {
        num2++;
        if (mem[n] != 0) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = fibonacci3(n - 1) + fibonacci3(n - 2);
    }

    public static long iterativeFibonacci(int n) {
        long[] data = new long[n + 1];
        data[0] = 0;
        data[1] = 1;

        for (int i = 0; i <= n - 1; i++) {
            data[i + 1] = data[i + 1] + data[i];
            if (i + 2 < data.length) {
                data[i + 2] = data[i + 2] + data[i];
            }
        }
        return data[n];
    }


}
