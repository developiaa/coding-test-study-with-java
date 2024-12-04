package programmers.level2.모음사전;

import java.util.ArrayList;
import java.util.List;

public class Solution2_review {
    private final static char[] CHARS = "AEIOU".toCharArray();

    public static void main(String[] args) {
        String s = "EIO"; // 1189
        System.out.println(solution(s));
    }

    public static int solution(String word){
        List<String> words = new ArrayList<>();
        generate("", words);
        System.out.println("words = " + words);
        return words.indexOf(word);
    }


    public static void generate(String word, List<String> words) {
        words.add(word);
        if (word.length() == 5) return;
        for (char c : CHARS) {
            generate(word + c, words);
        }
    }
}
