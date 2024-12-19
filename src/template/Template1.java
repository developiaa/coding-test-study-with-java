package template;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * String to Map
 * 글자의 빈도 수 확인
 * 중복 문자열 확인
 */
public class Template1 {
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
