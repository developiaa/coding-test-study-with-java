package programmers.level2.모음사전;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final static char[] CHARS = "AEIOU".toCharArray();

    public static void main(String[] args) {
        String s = "AAAAE"; // 6
        System.out.println(solution(s));
    }

    public static int solution(String word) {
        return generate("").indexOf(word);
    }

    public static List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) {
            return words;
        }

        for (char aChar : CHARS) {
            words.addAll(generate(word + aChar));
        }
        return words;
    }
}
