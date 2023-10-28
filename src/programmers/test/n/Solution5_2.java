package programmers.test.n;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution5_2 {
    public static void main(String[] args) {
        String S = "azABaabza"; // ABaab 5
//        String S = "TacoCat"; // -1
//        String S = "AcZCbaBz"; // 8
//        String S = "abcdefghijklmnopqrstuvwxyz"; // -1

        System.out.println(solution(S));
    }

    public static int solution(String s) {
        int answer = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String substring = s.substring(i, j);
                if (isBalanced(substring)) {
                    if (substring.length() > answer) {
                        answer = substring.length();
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isBalanced(String s) {
        Set<String> up = new HashSet<>();
        Set<String> lower = new HashSet<>();

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c >= 65 && c <= 90) {
                up.add(String.valueOf(c));
            } else {
                lower.add(String.valueOf(c));
            }
        }

        System.out.println(lower);
        System.out.println(up);

        for (String s1 : lower) {
            if (!up.contains(s1.toUpperCase())) {
                return false;
            }
        }
        for (String s1 : up) {
            if (!lower.contains(s1.toLowerCase())) {
                return false;
            }
        }

        return true;
    }

}
