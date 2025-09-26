package baekjoon._2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] h = new int[9];
        int[] ans = new int[9];
        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            sum += num;
            h[i] = num;
        }

        boolean found = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - h[i] - h[j] == 100) {
                    int answerIndex = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            ans[answerIndex++] = h[k];
                        }
                    }
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        insertionSort(ans);
//        Arrays.sort(ans);
        for (int i = 0; i < 9; i++) {
            if (ans[i] != 0) {
                System.out.println(ans[i]);
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int cur = arr[i];
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = cur;
                    break;
                }
            }
        }
    }
}
