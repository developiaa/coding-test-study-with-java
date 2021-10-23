package codility.lesson15;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSlices {
    public static void main(String[] args) {
        int M = 6;
        int[] A = {3, 4, 5, 5, 2};  //9
        System.out.println(solution(M, A));
    }

    //제대로 안됨..
    public static int solution(int M, int[] A) {
        int start = 0;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int i = 0;
        while (start < A.length && i < A.length) {
            if (set.contains(A[i])) {
                start++;
                i = start;
                set = new HashSet<>();
                continue;
            } else {
                System.out.println(start + ", " + i);
                count++;
//                System.out.println("count = " + count);
                set.add(A[i]);
                i++;
            }
        }
        return count;
    }
}
