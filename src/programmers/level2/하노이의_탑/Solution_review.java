package programmers.level2.하노이의_탑;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_review {
    public static void main(String[] args) {
        int n = 2;  // [[1,2], [1,3], [2,3]]

        int[][] solution = solution(n);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        hanoi(n, 1, 3, list);
        return list.toArray(new int[0][]);
    }

    private static List<int[]> hanoi(int n, int from, int to) {
        if (n == 1) return List.of(new int[]{from, to});

        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi(n-1, from, empty));
        result.addAll(hanoi(1, from , to));
        result.addAll(hanoi(n-1, empty, to));

        return result;
    }

    private static void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[]{from, to});
            return;
        }
        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }
}
