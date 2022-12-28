package programmers.level1.가장_가까운_같은_글자;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String s = "banana"; // [-1, -1, -1, 2, 2, 2]
        String s = "foobar"; // [-1, -1, 1, -1, -1, -1]
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer integer = map.get(c);
                map.put(c, i);
                answer[i] = i - integer;
            } else {
                answer[i] = -1;
                map.put(c, i);
            }
        }
        return answer;
    }
}
