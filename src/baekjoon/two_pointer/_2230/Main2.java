package baekjoon.two_pointer._2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(findMinDifference(N, M, A));
    }

    private static int findMinDifference(int N, int M, int[] A) {
        Arrays.sort(A); // 정렬
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int target = A[i] + M;
            int idx = lowerBound(A, target);

            if (idx < N) { // 범위 확인
                minDiff = Math.min(minDiff, A[idx] - A[i]);
            }
        }

        return minDiff;
    }

    // lowerBound: target 이상인 첫 번째 인덱스 찾기
    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
