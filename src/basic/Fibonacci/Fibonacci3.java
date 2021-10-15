package basic.Fibonacci;

public class Fibonacci3 {
    public static void main(String[] args) {
        int n = 10000;
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
