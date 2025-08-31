package baekjoon.dp._9252;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s1 = (" " + sc.next()).toCharArray();
        char[] s2 = (" " + sc.next()).toCharArray();
        int len1 = s1.length;
        int len2 = s2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int r = s1.length - 1;
        int c = s2.length - 1;
        while (r > 0 && c > 0) {
            if (s1[r] == s2[c]) {
                // sb.append(s1[r]);
                sb.append(s2[c]);
                r--;
                c--;
            } else {
                if (dp[r][c] == dp[r - 1][c]) {
                    r--;
                } else if (dp[r][c] == dp[r][c - 1]) {
                    c--;
                }
            }
        }
        System.out.println(dp[len1 - 1][len2 - 1]);
        System.out.println(sb.reverse());
    }
}
