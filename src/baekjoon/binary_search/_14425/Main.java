package baekjoon.binary_search._14425;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = sc.next();
        }

        Arrays.sort(str);

        int count = 0;
        while (M-- > 0) {
            String x = sc.next();
            if (isExist(str, x)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isExist(String[] arr, String x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compareResult = arr[mid].compareTo(x);
            if (compareResult < 0) {
                left = mid + 1;
            } else if (compareResult > 0) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
