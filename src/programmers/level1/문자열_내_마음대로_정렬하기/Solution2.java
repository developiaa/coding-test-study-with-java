package programmers.level1.문자열_내_마음대로_정렬하기;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1; // {"car","bed","sun"}
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) > o2.charAt(n)) {
                return 1;
            } else if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            } else if (o1.charAt(n) < o2.charAt(n)) {
                return -1;
            } else {
                return 0;
            }
        });

        return strings;
    }
}
