package programmers.test.bucket;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class test2 {
    public static void main(String[] args) {
//        String call = "abxdeydeabz"; //xyz
        String call = "ABCabcA";  //BCbc
        System.out.println(solution(call));
    }

    public static String solution(String call) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        int max = 0;
        String callCopy = call.toLowerCase();
        for (int i = 0; i < callCopy.length(); i++) {
            String s = String.valueOf(callCopy.charAt(i));
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                int value = map.get(s);
                value++;
                if (max < value) {
                    max = value;
                }
                map.put(s, value);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < callCopy.length(); i++) {
            String s = String.valueOf(callCopy.charAt(i));
            if (max != map.get(s)) {
                builder.append(call.charAt(i));
            }
        }

        System.out.println("map = " + map);
        System.out.println("max = " + max);
        System.out.println("builder = " + builder);
        return builder.toString();
    }
}
