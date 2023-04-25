package programmers.level2.행렬의_곱셈;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}}; // [[15, 15], [15, 15], [15, 15]]

        int[][] solution = solution(arr1, arr2);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
                for (int k = 0; k < arr1[i].length; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }

}
