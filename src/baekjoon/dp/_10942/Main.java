package baekjoon.dp._10942;

import java.util.Scanner;

public class Main {
    static int[][] dp = new int[2001][2001];
    static int[] arr = new int[2001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            sb.append(isPalindrome(start, end)).append("\n");
        }

        System.out.println(sb);

    }

    public static int isPalindrome(int start, int end) {
        if (start >= end) return 1;
        if (dp[start][end] != -1) return dp[start][end];
        if (arr[start] != arr[end]) {
            dp[start][end] = 0;
        } else {
            dp[start][end] = isPalindrome(start + 1, end - 1);
        }
        return dp[start][end];
    }
}
