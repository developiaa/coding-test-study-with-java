package codility.lesson8;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};    //0 or 2 or 4 or 6 or 7
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int mid = A.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                // 기존 값에서 +1
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                // 처음 갯수를 세는 거라면
                map.put(A[i], 1);
            }
        }
        System.out.println(map);

        // dominator 체크
        int value = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i) > mid) {
                value = i;
            }
        }
        System.out.println(value);
        if (value == 0) {
            return -1;
        } else {
            int index = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == value) {
                    index = i;
                }
            }
            return index;
        }


    }
}
