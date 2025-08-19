package baekjoon.recursion._2747;

import java.util.Scanner;

public class Main_preview {
    static int[] arr = new int[46];

    public static void main(String[] args) {
        arr[0] = 0;
        arr[1] = 1;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[N]);
    }
}
