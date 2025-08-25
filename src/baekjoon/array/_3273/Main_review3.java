package baekjoon.array._3273;

import java.util.Scanner;

public class Main_review3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int x = scanner.nextInt();

        boolean[] exist = new boolean[1_000_001];
        for (int i = 0; i < n; i++) {
            exist[arr[i]] = true;
        }

        int count = 0;
        for (int i = 1; i <= (x - 1) / 2; i++) {
            if (i <= 1000_000 && x - i <= 1000_000) {
                count += (exist[i] && exist[x - i]) ? 1 : 0;
            }
        }

        System.out.println(count);
    }
}
