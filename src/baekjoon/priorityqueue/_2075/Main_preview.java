package baekjoon.priorityqueue._2075;

import java.util.Arrays;
import java.util.Scanner;

// 시간 초과
public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[N * N - N]);
    }
}
