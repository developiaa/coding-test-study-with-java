package baekjoon.구간합._19951;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] delta = new int[N + 2];
        for (int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int v = sc.nextInt();

            delta[a] += v;
            delta[b + 1] -= v;
        }

        int[] acc = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] + delta[i];
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(acc[i] + arr[i] + " ");
        }
    }
}
