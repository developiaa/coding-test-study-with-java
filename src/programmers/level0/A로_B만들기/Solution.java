package programmers.level0.A로_B만들기;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String before = "olleh";
//        String after = "hello"; // 1

        String before = "allpe";
        String after = "apple"; // 0
        System.out.println(solution(before, after));
    }

    public static int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < before.length(); i++) {
            char c = before.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < after.length(); i++) {
            char c = after.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return 0;
            }
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                return 0;
            }
        }
        return 1;
    }
}
