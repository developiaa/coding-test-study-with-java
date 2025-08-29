package baekjoon.recursion._2747;

import java.util.Scanner;

public class Main_review {
    static int[] answer;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[n]);

        answer = new int[n + 1];
        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (answer[n] != 0) {
            return answer[n];
        }
        return answer[n] = fibo(n - 1) + fibo(n - 2);

    }
}
