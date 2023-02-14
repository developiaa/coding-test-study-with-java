package programmers.level2.귤_고르기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3}; //3

//        int k = 4;
//        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3}; //2

//        int k = 2;
//        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3}; //1
        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        System.out.println("list = " + list);
        int i = 0;
        while (k > 0) {
            k = k - map.get(list.get(i));
            answer++;
            i++;
        }

        return answer;
    }

}
