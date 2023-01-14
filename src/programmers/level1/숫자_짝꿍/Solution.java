package programmers.level1.숫자_짝꿍;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String X = "100";
//        String Y = "2345";// -1
//        String X = "100";
//        String Y = "203045";// 0
//        String X = "100";
//        String Y = "123450";// 10
        String X = "12321";
        String Y = "42531";// 321
//        String X = "5525";
//        String Y = "1255";// 552
        System.out.println(solution(X, Y));
    }

    public static String solution(String X, String Y) {
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            Integer c = Integer.valueOf(X.charAt(i) - '0');
            if (mapX.containsKey(c)) {
                mapX.put(c, mapX.get(c) + 1);
            } else {
                mapX.put(c, 1);
            }
        }

        for (int i = 0; i < Y.length(); i++) {
            Integer c = Integer.valueOf(Y.charAt(i) - '0');
            if (mapY.containsKey(c)) {
                mapY.put(c, mapY.get(c) + 1);
            } else {
                mapY.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (mapX.containsKey(i) && mapY.containsKey(i)) {
                if (sb.length() == 0 && i == 0) {
                    return "0";
                }
                for (int j = 0; j < Math.min(mapX.get(i), mapY.get(i)); j++) {
                    sb.append(i);
                }
            }
        }
        if (sb.length() == 0) {
            return "-1";
        }
        return sb.toString();
    }

}
