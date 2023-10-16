package programmers.level0.중복된_문자_제거;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//        String my_string = "people"; //peol
        String my_string = "We are the world"; //We arthwold
        System.out.println(solution(my_string));

    }

    public static String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

}
