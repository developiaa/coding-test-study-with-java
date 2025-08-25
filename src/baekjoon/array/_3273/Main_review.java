package baekjoon.array._3273;

import java.util.Arrays;
import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        int count = 0;
        int x = sc.nextInt();
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (x < sum) {
                r--;
            } else if (x > sum) {
                l++;
            } else {
                count++;
                r--;
                l++;
            }
        }
        System.out.println(count);
    }
}
