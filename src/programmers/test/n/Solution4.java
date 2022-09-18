package programmers.test.n;

import java.util.HashSet;
import java.util.Set;

public class Solution4 {
    public static void main(String[] args) {
//        int[] A = {1, 2, 2, 1}; // true
//        int[] A = {7,7,7}; // false
        int[] A = {1,2,2,3}; // false
        System.out.println(solution(A));
    }

    public static boolean solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                set.remove(A[i]);
            } else {
                set.add(A[i]);
            }
        }

        return set.isEmpty();
    }
}
