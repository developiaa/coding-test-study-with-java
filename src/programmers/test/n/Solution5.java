package programmers.test.n;

import java.util.HashSet;
import java.util.Set;

public class Solution5 {
    public static void main(String[] args) {
//        String S = "azABaabza"; // ABaab 5
//        String S = "TacoCat"; // -1
        String S = "AcZCbaBz"; // 8
//        String S = "abcdefghijklmnopqrstuvwxyz"; // -1

        System.out.println(solution(S));
    }

    public static int solution(String S) {
        int count = -1;
        for (int i = 0; i < S.length(); i++) {
            for (int k = i + 1; k <= S.length(); k++) {
                String substring = S.substring(i, k);
                System.out.println("i=" + i + " ,k=" + k + "  " + substring);
                if (isBalanced(substring)) {
//                    System.out.println("i=" + i + " ,k=" + k + "  " + substring);
                    if (count < substring.length()) {
                        count = substring.length();
                    }
                }
            }
        }
        return count;
    }

    public static boolean isBalanced(String s) {
        Set<String> small = new HashSet<>();
        Set<String> big = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                // 대문자인경우
                big.add(String.valueOf(s.charAt(i)));
            } else {
                small.add(String.valueOf(s.charAt(i)));
            }
        }

        for (String s1 : small) {
            if (!big.contains(s1.toUpperCase())) {
                return false;
            }
        }
        for (String s1 : big) {
            if (!small.contains(s1.toLowerCase())) {
                return false;
            }
        }

        return true;

    }
}
