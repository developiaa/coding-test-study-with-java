package codility.lesson3;

import java.util.*;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        //Queue로 할 경우 타임 초과
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= A.length + 1; i++) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            set.remove(A[i]);
        }

        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
}
