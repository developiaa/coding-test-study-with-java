package baekjoon.binary_search._2470;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int findOptimalPairValue(int[] arr, int fromIndex, int toIndex, int value) {
        int optimalPairAbs = 200000000;
        int optimalPairValue = 0;
        int l = fromIndex;
        int r = toIndex;
        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = value + arr[mid];

            int sumAbs = Math.abs(sum);
            if (sumAbs < optimalPairAbs) {
                optimalPairValue = arr[mid];
                optimalPairAbs = sumAbs;
            }

            if (sum < 0) {
                l = mid + 1;
            } else if (sum > 0) {
                r = mid - 1;
            } else {
                return arr[mid];
            }
        }
        return optimalPairValue;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ansAbs = 200000000;
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < N - 1; i++) {
            int pairValue = findOptimalPairValue(arr, i + 1, N - 1, arr[i]);
            int abs = Math.abs(arr[i] + pairValue);
            if (abs < ansAbs) {
                ansAbs = abs;
                ans1 = arr[i];
                ans2 = pairValue;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
