package baekjoon.two_pointer._2230;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int l = i, r = N - 1;

            while (l <= r) {
                int m = (l + r) / 2;
                int diff = arr[m] - arr[i];
                if (diff >= M) {
                    ans = Math.min(ans, diff);
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }

        System.out.println(ans);
    }
}
