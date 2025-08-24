package baekjoon.binary_search._1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
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
            if (binarySearch(arr, sc.nextInt())) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean binarySearch(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > num) {
                r = mid - 1;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
