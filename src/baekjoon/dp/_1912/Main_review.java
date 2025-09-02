package baekjoon.dp._1912;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sum = new int[n];
        sum[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i - 1] + arr[i], arr[i]);
            max = Math.max(max, sum[i]);
        }
        System.out.println(max);
    }
}
