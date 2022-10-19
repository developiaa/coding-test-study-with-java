package programmers.level2.영어_끝말잇기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 23m
public class Solution {
    public static void main(String[] args) {
//        int n = 3;
//        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}; //{3,3}
        int n = 3;
        String[] words = {"tank", "no", "know", "wheel", "land", "dream", "mother", "robot", "tank"}; //{2,1}
//        int n = 2;
//        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(n, words)));

    }

    public static int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;
        int num = 0;
        String lastWord = String.valueOf(words[0].charAt(words[0].length() - 1));
        for (int i = 0; i < words.length; i++) {
            if ((i + 1) % n == 1) {
                count++;
            }

            String word = words[i];
            if (set.contains(word) || (i != 0 && !word.startsWith(lastWord))) {
                num = (i + 1) % n == 0 ? n : (i + 1) % n;
                return new int[]{num, count};
            } else {
                set.add(word);
                lastWord = String.valueOf(word.charAt(words[i].length() - 1));
            }

        }
        return new int[]{0, 0};
    }
}
