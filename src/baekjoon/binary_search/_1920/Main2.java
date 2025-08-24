package baekjoon.binary_search._1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int idx = Arrays.binarySearch(arr, sc.nextInt());
            System.out.println(idx >= 0 ? 1 : 0);
        }
    }
}
