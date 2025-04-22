package baekjoon.two_pointer._1806;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int ansLength = N + 1;
        int rightIndex = 0;
        int currentSum = arr[0];
        for (int i = 0; i < N; i++) {
            while (currentSum < S && rightIndex < N - 1) {
                currentSum += arr[++rightIndex];
            }
            if (currentSum >= S) {
                ansLength = Math.min(ansLength, rightIndex - i + 1);
            }
            currentSum -= arr[i];
        }

        if (ansLength > N) {
            ansLength = 0;
        }

        System.out.println(ansLength);
    }
}
