package programmers.level1.완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();
        for (String name : participant) {
            count.putIfAbsent(name, 0);
            count.put(name, count.get(name) + 1);
        }

        for (String name : completion) {
            int i = count.get(name) - 1;
            count.put(name, i);
            if (i == 0) {
                count.remove(name);
            }
        }

        return count.keySet().iterator().next();
    }
}
