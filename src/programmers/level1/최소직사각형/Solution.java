package programmers.level1.최소직사각형;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}; // 4000
        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}; // 120
        System.out.println(solution(sizes));
    }

    // 1번 문제 런타임 에러 for문 2번써서 그런듯.
//    public static int solution(int[][] sizes) {
//        int max = 0;
//        for (int[] size : sizes) {
//            for (int j = 0; j < sizes[1].length; j++) {
//                if (max <= size[j]) {
//                    max = size[j];
//                }
//            }
//        }
//
//        int[] array = new int[sizes.length];
//        for (int i = 0; i < sizes.length; i++) {
//            array[i] = Math.min(sizes[i][0], sizes[i][1]);
//        }
//
//        Arrays.sort(array);
//
//        return max * array[sizes.length - 1];
//    }

    public static int solution(int[][] sizes) {
        int max = 0;
        for (int[] size : sizes) {
            int temp = Math.max(size[0], size[1]);
            if (max < temp) {
                max = temp;
            }
        }

        int[] array = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            array[i] = Math.min(sizes[i][0], sizes[i][1]);
        }

        Arrays.sort(array);

        return max * array[sizes.length - 1];
    }
}
