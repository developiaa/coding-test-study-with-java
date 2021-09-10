package basic;

import java.util.Arrays;

// 순서 없이 n개중에서 r개를 뽑는 경우
// 사용 예시 permutation(arr, 0, n, 4)
public class PermutationTest {
    static int COUNT = 0;

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
            //하나를 고정시켜주고 나머지들의 위치를 변경한다.
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            //이전 상태로 위치를 돌려주어야 순열이 제대로 동작한다.
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
