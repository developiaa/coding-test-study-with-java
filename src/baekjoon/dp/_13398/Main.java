package baekjoon.dp._13398;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[2][n];
        dp[0][0] = arr[0];
        int max = dp[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], 0) + arr[i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[i]);

            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }
        System.out.println(max);
    }
}
