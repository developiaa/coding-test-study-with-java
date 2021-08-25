package basic;

import java.util.Arrays;

// 순서 없이 n개중에서 r개를 뽑는 경우
// 사용 예시 permutation(arr, 0, n, 4)
public class PermutationTest {
    static int COUNT=0;
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5, 6};
        Arrays.sort(arr);
        permutation(arr, 0, arr.length, 3);
        System.out.println("COUNT = " + COUNT);
    }

    public static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(arr) + " " + r);
            COUNT++;
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, 1);
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
