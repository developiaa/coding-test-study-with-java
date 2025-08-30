package baekjoon.dp._9251;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] first = (" " + sc.next()).toCharArray();
        char[] second = (" " + sc.next()).toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        for (int i = 1; i < first.length; i++) {
            for (int j = 1; j < second.length; j++) {
                if (first[i] == second[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[first.length - 1][second.length - 1]);
    }
}
