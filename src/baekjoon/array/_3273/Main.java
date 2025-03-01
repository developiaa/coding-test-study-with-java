package baekjoon.array._3273;

import java.util.Scanner;

public class Main {
    // 3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        int X = scanner.nextInt();

        boolean[] exist = new boolean[1000001];
        for (int i = 0; i < N; i++) {
            exist[a[i]] = true;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int pairValue = X - a[i];
            if (0 <= pairValue && pairValue <= 1000000) {
                ans += exist[pairValue] ? 1 : 0;
            }
        }

        System.out.println(ans / 2);
    }
}
