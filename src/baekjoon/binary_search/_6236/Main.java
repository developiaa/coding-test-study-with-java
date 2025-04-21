package baekjoon.binary_search._6236;

import java.util.Scanner;

public class Main {
    public static boolean isPossible(int[] arr, int drawAmount, int maxAmount) {
        int drawCount = 1;
        int current = drawAmount;
        for (int userAmount : arr) {
            if (userAmount > drawAmount) return false;
            if (current < userAmount) {
                if (drawCount == maxAmount) return false;
                drawCount++;
                current = drawAmount;
            }
            current -= userAmount;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 1;
        int right = N * 10_000;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(arr, mid, M)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
