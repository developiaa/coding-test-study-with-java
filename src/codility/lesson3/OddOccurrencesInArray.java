package codility.lesson3;

import java.util.*;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        // int[] A = {9, 3, 9, 3, 9, 7, 9}; // 7
        // int[] A = {3,5,5,3,1}; // 1
        // int[] A = {3,1,1,3,7}; // 7
        int[] A = {7, 3, 7, 3, 9, 1, 1, 3, 3, 1, 1, 3, 3, 11, 1, 33, 3, 5, 5, 11, 1, 33, 3, 7, 7, 99, 101, 99, 101}; // 9
        System.out.println(solution(A));
    }

    //시간 초과로 안되는 듯
    public static int solution(int[] A) {
        System.out.println(A.length);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int count = 1;
            if (map.containsKey(A[i])) {
                count = count + map.get(A[i]);
            }
            map.put(A[i], count);
        }
        System.out.println(map);
        int a = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                a = integer;
            }
        }
        return a;
    }
}
