package codility.lesson15;

import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {
    public static void main(String[] args) {
        int[] A = {-5, -3, -1, 0, 3, 6};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!set.contains(Math.abs(A[i]))){
                set.add(Math.abs(A[i]));
                count++;
            }
        }
        return count;
    }
}
