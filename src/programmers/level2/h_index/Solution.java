package programmers.level2.h_index;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5, 4}; // 3
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length; i >= 1; i--) {
            if (isValid(citations, i)) return i;
        }

        return 0;
    }

    //    public static boolean isValid(int[] citations, int h) {
//        int count = 0;
//        for (int citation : citations) {
//            if (citation >= h) {
//                count++;
//            }
//        }
//        return count >= h;
//    }
    public static boolean isValid(int[] citations, int h) {
        int index = citations.length - h;
        return citations[index] >= h;
    }
}
