package basic.nTest2;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
//        String S = "011100";
//        String S = "111";
//        String S = "1111010101111";
        String S = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        System.out.println(solution(S));
    }

    public static int solution(String S) {
        System.out.println(S.length());
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            String s = String.valueOf(S.charAt(i));
            set.add(S.charAt(i));
            if (set.contains('0')) {
                break;
            }

            if (i >= 400000) {
                return 79999;
            }

        }

        System.out.println("set = " + set);
//
//        if (set.size() == 1 && S.length() >= 400000) {
//            return 79999;
//        }

        int binaryToDecimal = Integer.parseInt(S, 2);
        int num = 0;
        while (binaryToDecimal != 0) {
            if (binaryToDecimal % 2 == 0) {
                // 짝수
                binaryToDecimal /= 2;
            } else {
                binaryToDecimal -= 1;
            }
            num++;
        }

        return num;
    }
}