package baekjoon.binary_search._14425;

import java.util.Arrays;
import java.util.Scanner;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            String next = sc.next();
            arr[i] = next;
        }

        Arrays.sort(arr);
        int count = 0;
        while (M-- > 0) {
            String s = sc.next();
            if (isExist(arr, s)) {
                count++;
            }
        }

        System.out.println(count);

    }

    public static boolean isExist(String[] arr, String s) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid].compareTo(s) < 0) {
                l = mid + 1;
            } else if (arr[mid].compareTo(s) > 0) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
