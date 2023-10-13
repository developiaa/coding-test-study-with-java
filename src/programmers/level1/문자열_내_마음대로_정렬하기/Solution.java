package programmers.level1.문자열_내_마음대로_정렬하기;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        String[] strings = {"sun", "bed", "car"};
        String[] strings = {"abce", "abcd", "cdx"};
//        int n = 1; // {"car","bed","sun"}
        int n = 2; // {"abcd","abce","cdx"}
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    public static String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            list.add(string.charAt(n) + string);
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }
        return answer;
    }
}
