package programmers.test.n2506;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3};
        int[] B = {1, 3, 2, 3}; // 2

//        int[] A = {3,2,1,6,5};
//        int[] B = {4,2,1,3,3}; // 3

//        int[] A = {1, 2};
//        int[] B = {1, 2}; // 3
        System.out.println(solution(A, B));
    }

//    public static int solution3(int[] A, int[] B) {
//        int[] checked = new int[100001];
//        Arrays.fill(checked, -1);
//
//        for (int i = 0; i < A.length; i++) {
//            checked[Math.max(A[i], B[i])] = 1;
//        }
//
//        for (int i = 1; i < checked.length; i++) {
//            if (checked[i] <= 0) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public static int solution(int[] A, int[] B) {
        boolean[] used = new boolean[100001];

        for (int i = 0; i < A.length; i++) {
            used[Math.max(A[i], B[i])] = true;
        }

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                return i;
            }
        }
        return -1;
    }

//
//    public static int solution2(int[] A, int[] B) {
//        int maxValue = 0;
//        for (int i = 0; i < A.length; i++) {
//            maxValue = Math.max(maxValue, Math.max(A[i], B[i]));
//        }
//
//        boolean[] used = new boolean[maxValue + 2]; // 최대값보다 1 크고, 1부터 시작하므로 +2
//
//        for (int i = 0; i < A.length; i++) {
//            used[Math.max(A[i], B[i])] = true;
//        }
//
//        for (int i = 1; i < used.length; i++) {
//            if (!used[i]) {
//                return i;
//            }
//        }
//
//        return -1; // 이론상 도달하지 않음
//    }
}
