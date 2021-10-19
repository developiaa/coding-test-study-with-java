package basic;

public class Combination2 {
    public static void main(String[] args) {
        int n = 4;
        int r = 2;
        int[] a = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        combination(n, r, a, visited, 0);
    }

    public static void combination(int n, int r, int[] arr, boolean[] visited, int depth) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (depth == n) {
            return;
        }


        visited[depth] = true;
        combination(n, r - 1, arr, visited, depth + 1);

        visited[depth] = false;
        combination(n, r, arr, visited, depth + 1);
    }
}
