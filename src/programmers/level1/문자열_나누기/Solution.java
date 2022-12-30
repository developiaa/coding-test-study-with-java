package programmers.level1.문자열_나누기;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
//        String s = "banana"; //3
        String s = "abracadabra"; //6
//        String s = "aaabbaccccabba"; //3

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int count = 0;
        char first = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                first = s.charAt(i);
                if (map.containsKey(first)) {
                    map.put(first, map.get(first) + 1);
                } else {
                    map.put(first, 1);
                }
            } else {
                char c = s.charAt(i);
                if (first != c) {
                    c = 'A';
                    if (Objects.equals(map.get(first), map.containsKey(c) ? map.get(c) + 1 : 1)) {
                        count++;
                        s = s.substring(i + 1);
                        map.clear();
                        first = ' ';
                        i = -1;
                        continue;
                    }
                }
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        if (map.containsKey(first)) {
            count++;
        }
        return count;
    }
}
