package programmers.level1._1차_비밀지도;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int n = 5;
//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28}; // {"#####","# # #", "### #", "# ##", "#####"}

        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
//        int[] arr1 = {46, 33, 33, 22, 31, 50, 50 , 50 , 50 , 50, 50 , 50 , 50 , 50 , 50 , 50000 };
        int[] arr2 = {27, 56, 19, 14, 14, 10}; // {"######", "### #", "## ##", " #### ", " #####", "### # "}
//        int[] arr2 = {27, 56, 19, 14, 14, 10, 10 , 10 , 10 , 10, 10, 10, 10 , 10, 10, 10}; // {"######", "### #", "## ##", " #### ", " #####", "### # "}
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] array = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            s1 = "0".repeat(Math.max(0, n - s1.length())) + s1;
            s2 = "0".repeat(Math.max(0, n - s2.length())) + s2;

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == '1' || s2.charAt(j) == '1') {
                    stringBuilder.append("#");
                } else {
                    stringBuilder.append(" ");
                }
            }
            array[i] = stringBuilder.toString();
        }
        return array;
    }

    // 런타임 에러
    public static String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] array = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            String s = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr1[i])));
            String s2 = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr2[i])));
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1' || s2.charAt(j) == '1') {
                    stringBuilder.append("#");
                } else {
                    stringBuilder.append(" ");
                }
            }
            array[i] = stringBuilder.toString();
        }
        return array;
    }

    public static int[][] chageArray(int[] arr) {
        int[][] array = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            String s = String.format("%05d", Integer.parseInt(Integer.toBinaryString(arr[i])));
            for (int j = 0; j < s.length(); j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }

        return array;
    }


}
