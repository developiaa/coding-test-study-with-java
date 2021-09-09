package codility.lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne2 {
    public static void main(String[] args) {
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(X, A));
    }

    public static int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) {
                return i;
            }
        }
        return -1;

    }
}
