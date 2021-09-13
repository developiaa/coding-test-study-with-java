package codility.lesson4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MissingInteger2 {
    // 주어진 배열에서 나타나지 않은 가장 작은 양의 정수 출력
    public static void main(String[] args) {
//        int[] A = {1, 3, 6, 4, 1, 2}; //5
        int[] A = {1, 2, 3}; //4
//        int[] A = {-1, -3}; //1
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;


    }

}
