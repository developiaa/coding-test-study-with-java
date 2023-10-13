package programmers.level1.문자열_내_마음대로_정렬하기;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
//        String[] strings = {"sun", "bed", "car"};
        String[] strings = {"abce", "abcd", "cdx"};
//        int n = 1; // {"car","bed","sun"}
        int n = 2; // {"abcd","abce","cdx"}
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) != o2.charAt(n)) {
                return o1.charAt(n) - o2.charAt(n);
            }
            return o1.compareTo(o2);
        });
        return strings;
    }
}
