package programmers.test.n;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution6 {
    public static void main(String[] args) {
//        String S = "ACAX"; //16
//        String S = "CODILITY"; //96
        String S = "ACACA"; //16

        System.out.println(solution(S));
    }

    public static int solution(String S) {
        String[] split = S.split("");
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = i + 1; j <= split.length; j++) {
                String substring = S.substring(i, j);
                System.out.println("substring = " + substring);

                Map<Character, Integer> map = new HashMap<>();
                for (int m = 0; m < substring.length(); m++) {
                    if (map.containsKey(substring.charAt(m))) {
                        map.put(substring.charAt(m), map.get(substring.charAt(m))+1);
                    } else {
                        map.put(substring.charAt(m), 1);
                    }
                }
                for (Character character : map.keySet()) {
                    if (map.get(character) == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }


}
