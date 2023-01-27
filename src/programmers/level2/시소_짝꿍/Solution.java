package programmers.level2.시소_짝꿍;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};
        System.out.println(solution(weights)); //4
    }

    public static long solution(int[] weights) {
        long answer = 0L;
        int[] arr = {2, 3, 4};
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < weights.length; i++) {
            set.add(weights[i]);
            if (map.containsKey(weights[i])) {
                List<Integer> integers = map.get(weights[i]);
                integers.add(i);
                map.put(weights[i], integers);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(weights[i], list);
            }
        }

        for (int key : set) {
            int dupli = map.get(key).size();

            int wX2 = key * 2;
            if (wX2 % 3 == 0) {
                if (map.containsKey(wX2 / 3)) {
                    answer += (long) map.get(wX2 / 3).size() * dupli;
                }
            }

            if (wX2 % 4 == 0) {
                if (map.containsKey(wX2 / 4)) {
                    answer += (long) map.get(wX2 / 4).size() * dupli;
                }
            }

            int wX3 = key * 3;
            if (wX3 % 2 == 0) {
                if (map.containsKey(wX3 / 2)) {
                    answer += (long) map.get(wX3 / 2).size() * dupli;
                }
            }

            if (wX3 % 4 == 0) {
                if (map.containsKey(wX3 / 4)) {
                    answer += (long) map.get(wX3 / 4).size() * dupli;
                }
            }

            int wX4 = key * 4;
            if (map.containsKey(wX4 / 2)) {
                answer += (long) map.get(wX4 / 2).size() * dupli;
            }

            if (wX4 % 3 == 0) {
                if (map.containsKey(wX4 / 3)) {
                    answer += (long) map.get(wX4 / 3).size() * dupli;
                }
            }

            if (dupli > 1) {
                answer += (long) dupli * (long) (dupli - 1) / 2;
            }

            map.remove(key);

        }

        return answer;
    }

}
