package codility.lesson9;

import java.util.ArrayList;
import java.util.List;

//correct 100%, efficient 20%..
public class MaxProfit {
    public static void main(String[] args) {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        boolean[] visited = new boolean[A.length];

        combination(A.length, 2, A, visited, 0);
        return max;
    }

    public static int max = 0;

    public static void combination(int n, int r, int[] A, boolean[] visited, int depth) {
        if (r == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = A.length - 1; i >= 0; i--) {
                if (visited[i]) {
                    list.add(A[i]);
                    System.out.print(A[i] + " ");
                }
            }
            System.out.println();
            int num = list.get(0) - list.get(1);

            if (num>0 && max < num) {
                max = num;
            }

            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(n, r - 1, A, visited, depth + 1);

        visited[depth] = false;
        combination(n, r, A, visited, depth + 1);

    }
}
