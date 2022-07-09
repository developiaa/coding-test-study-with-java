package programmers.level1.숫자_문자열과_영단어;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
//        String s = "one4seveneight"; //1478
        String s = "2three45sixseven"; //234567
//        String s = "2zero000000nine";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < strings.length; i++) {
            s = s.replaceAll(strings[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
