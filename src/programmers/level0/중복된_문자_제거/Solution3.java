package programmers.level0.중복된_문자_제거;

import java.util.stream.Collectors;

public class Solution3 {
    public static void main(String[] args) {
//        String my_string = "people"; //peol
        String my_string = "We are the world"; //We arthwold
        System.out.println(solution(my_string));

    }

    public static String solution(String my_string) {
        return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }

}
