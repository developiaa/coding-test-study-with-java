package programmers.test.n;

import java.util.Arrays;

public class Solution1_2 {
    public static void main(String[] args) {
        String s = "?ab??a"; //aabbaa
//        String s = "bab??a"; //NO
//        String s = "?a?"; //aaa, zaz

        System.out.println(solution(s));
    }


    public static String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if (c1 == '?' && c2 != '?') {
                stringBuilder.append(c2);
                stringBuilder2.insert(0, c2);
            } else if (c1 != '?' && c2 == '?') {
                stringBuilder.append(c1);
                stringBuilder2.insert(0, c1);
            } else if (c1 == '?' && c2 == '?') {
                stringBuilder.append("a");
                stringBuilder2.insert(0, "a");
            } else {
                if (i == j) {
                    stringBuilder.append(c1);
                    break;
                }
                return "NO";
            }
            i++;
            j--;
        }

        return stringBuilder + stringBuilder2.toString();
    }
}
