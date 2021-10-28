package basic.nTest;

import java.util.HashSet;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
//        String s = "azABaabza"; //ABaab 5
//        String s = "TacoCat"; //-1
        String s = "CATattac"; //-1
        System.out.println(solution(s));
    }

    public static int solution(String S) {
        System.out.println(S);
        int min_count = Integer.MAX_VALUE;
        for (int i = 0; i <= S.length(); i++) {
            for (int j = i; j <= S.length(); j++) {
                String substring = S.substring(i, j);
                boolean bal = isBal(substring);
                if (bal) {
                    System.out.println(substring);
                    if (min_count > substring.length()) {
                        min_count = substring.length();
                    }
                }
            }
        }
        if (min_count == Integer.MAX_VALUE) {
            return -1;
        }
        return min_count;
    }

    public static boolean isBal(String s) {
        //대문자 담을 집합
        Set<String> set1 = new HashSet<>();
        //소문자 담을 집합
        Set<String> set2 = new HashSet<>();
        //소문자를 대문자로 변경하여 담을 집합
        Set<String> set3 = new HashSet<>();

        //대소문자 분리
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 64 && s.charAt(i) < 91) {
                set1.add(String.valueOf(s.charAt(i)));
            }
            if (s.charAt(i) > 96 && s.charAt(i) < 123) {
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
