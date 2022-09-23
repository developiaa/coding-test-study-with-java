package programmers.level1._1차_비밀지도;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
//        int n = 5;
//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28}; // {"#####","# # #", "### #", "# ##", "#####"}

        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10}; // {"######", "### #", "## ##", " #### ", " #####", "### # "}
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            array[i] = String.format("%" + n + "s", array[i]);
            array[i] = array[i].replaceAll("1", "#");
            array[i] = array[i].replaceAll("0", " ");
        }

        return array;
    }



}
