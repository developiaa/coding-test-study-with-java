package programmers.level0.중복된_문자_제거;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
//        String my_string = "people"; //peol
        String my_string = "We are the world"; //We arthwold
        System.out.println(solution(my_string));

    }

    public static String solution(String my_string) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(my_string.split("")));
        return String.join("", set);
    }

}
