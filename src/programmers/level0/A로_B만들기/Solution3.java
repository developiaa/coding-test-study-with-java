package programmers.level0.A로_B만들기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution3 {
    public static void main(String[] args) {
        String before = "olleh";
        String after = "hello"; // 1

//        String before = "allpe";
//        String after = "apple"; // 0
        System.out.println(solution(before, after));
    }

    public static int solution(String before, String after) {
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }

    public static Map<Character, Integer> toMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public static Map<String, Long> toMap2(String word) {
        return Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));
    }
}
