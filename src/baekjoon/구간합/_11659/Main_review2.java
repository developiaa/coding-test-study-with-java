package baekjoon.구간합._11659;

import java.util.Scanner;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }
    }
}
