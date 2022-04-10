package basic.nTest;

import java.util.HashSet;
import java.util.Set;

public class example7 {
    public static void main(String[] args) {
        String S = "CATattac";

        System.out.println(solution(S));
    }

    public static int solution(String S) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j < S.length(); j++) {
                String substring = S.substring(i, j + 1);
                System.out.println("substring = " + substring);
                boolean balance = isBalance(substring);
                if (balance) {
                    int length = substring.length();
                    if (min > length) {
                        min = length;
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

    public static boolean isBalance(String s) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                set1.add(String.valueOf(s.charAt(i)));
            }
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                set2.add(String.valueOf(s.charAt(i)));
                set3.add(String.valueOf(s.charAt(i)).toUpperCase());
            }
        }

        if (set1.size() != 0 && set1.size() == set2.size() && set1.equals(set3)) {
            return true;
        }
        return false;
    }
}
