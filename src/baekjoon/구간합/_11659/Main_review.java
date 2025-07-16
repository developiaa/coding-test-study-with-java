package baekjoon.구간합._11659;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];
        int[] acc = new int[N + 1];
        acc[0] = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] + arr[i];
        }

        while (M-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(acc[b] - acc[a - 1]);
        }

    }
}
