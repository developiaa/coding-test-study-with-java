package basic.nTest;

import java.util.HashSet;
import java.util.Set;

public class example5 {
    public static void main(String[] args) {
//        String S = "ACAX";
        String S = "CODILITY";
//        String S = "ACACA";

        System.out.println(solution(S));
    }

    public static int solution(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int test = test(s.substring(i, j+1));
                sum += test;
            }
        }
        return sum;
    }

    public static int test(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size();
    }
}
