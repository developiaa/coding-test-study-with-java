package programmers.level1.숫자_문자열과_영단어;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String s = "one4seveneight"; //1478
//        String s = "2three45sixseven"; //234567
        String s = "2zero000000nine";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tempAlphabet = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 65 || c > 122) {
                //숫자일 경우
                sb.append(c);
                continue;
            }

            tempAlphabet.append(c);
            boolean alphabetNumber = isAlphabetNumber(tempAlphabet.toString());
            if (alphabetNumber) {
                int number = convertString2Number(tempAlphabet.toString());
                sb.append(number);
                tempAlphabet.setLength(0);
            }

        }


        return Integer.parseInt(sb.toString());
    }

    public static int convertString2Number(String s) {
        Map<String, Integer> map = new HashMap<>() {
            {
                put("zero", 0);
                put("one", 1);
                put("two", 2);
                put("three", 3);
                put("four", 4);
                put("five", 5);
                put("six", 6);
                put("seven", 7);
                put("eight", 8);
                put("nine", 9);
            }
        };

        return map.get(s);
    }

    public static boolean isAlphabetNumber(String s) {
        List<String> list = new ArrayList<>(List.of(
                "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "zero"));

        return list.contains(s);
    }
}
