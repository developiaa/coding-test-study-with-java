package codility.lesson8;

import java.util.*;

public class EquiLeader {
    public static void main(String[] args) {
        int[] A = {4, 3, 4, 4, 4, 2};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int leader = 0;
        int leaderCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
            if (leaderCount < map.get(A[i])) {
                leaderCount = map.get(A[i]);
                leader = A[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        int currentCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                currentCount++;
            }
            list.add(currentCount);
        }
        System.out.println("map = " + map);
        System.out.println("list = " + list);

        for(int i=0; i<A.length-1;i++){
            int leftCount = list.get(i);
            int rightCount = list.get(list.size() - 1) - leftCount;

            int limitEquiLeft = ((i+1)/2)+1;
            int limitEquiRight = ((A.length-(i+1))/2)+1;

            if((leftCount>=limitEquiLeft) && (rightCount>=limitEquiRight)){
                result++;
            }
        }

        return result;
    }


}
