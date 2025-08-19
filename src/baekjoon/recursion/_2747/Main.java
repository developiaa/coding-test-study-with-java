package baekjoon.recursion._2747;

import java.util.Scanner;

public class Main {
    static int[] arr = new int[50];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fibo(N));
    }

    static int fibo(int n) {
        if (n == 0 || n == 1)
            return n;
        if (arr[n] != 0) {
            return arr[n];
        }
        return arr[n] = fibo(n - 1) + fibo(n - 2);
    }
}
