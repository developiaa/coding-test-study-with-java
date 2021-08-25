package basic;

import java.util.Arrays;

public class PermutationTest2 {
    static int COUNT = 0;

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5, 6};
        int[] output = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        Arrays.sort(arr);
        permutation(arr, output, visited, 0, arr.length, 3);
        System.out.println("COUNT = " + COUNT);
    }

    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(output) + " " + r);
            COUNT++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }

    }
}
