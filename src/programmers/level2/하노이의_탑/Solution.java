package programmers.level2.하노이의_탑;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 매 부분문제마다 리스트를 새로 만들고 이어붙이는 부분은 문제를 해결할 때마다
 * 구해 놓은 과정을 전부 순회해야 하므로 비효율적
 */
public class Solution {
    public static void main(String[] args) {
        int n = 2;  // [[1,2], [1,3], [2,3]]

        int[][] solution = solution(n);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] solution(int n) {
        return hanoi(n, 1, 3).toArray(new int[0][]);
    }

    private static List<int[]> hanoi(int n, int from, int to) {
        if (n == 1) {
            return List.of(new int[]{from, to});
        }

        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi(n - 1, from, empty));
        result.addAll(hanoi(1, from, to));
        result.addAll(hanoi(n - 1, empty, to));

        return result;
    }
}
