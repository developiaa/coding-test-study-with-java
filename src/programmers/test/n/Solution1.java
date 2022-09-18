package programmers.test.n;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        String s = "?ab??a"; //aabbaa
//        String s = "bab??a"; //NO
//        String s = "?a?"; //aaa, zaz

        System.out.println(solution(s));
    }

//    public static String solution(String s) {
//        int p = 0;
//        int q = s.length() - 1;
//        String answer = "";
//        while (p <= q) {
//            if (s.charAt(p) != '?' && s.charAt(q) != '?' && s.charAt(p) != s.charAt(q)) {
//                return "NO";
//            }
//            if (s.charAt(p) == '?' && s.charAt(q) != '?') {
//                answer += s.charAt(q);
//            } else if (s.charAt(p) != '?' && s.charAt(q) == '?') {
//                answer += s.charAt(p);
//            } else {
//                answer += "?";
//            }
//            p++;
//            q--;
//        }
//
//        return answer.replaceAll("\\?", "a");
//    }

    public static String solution(String s) {
        int p = 0;
        int q = s.length() - 1;
        String[] arr = s.split("");
        String answer = "";
        while (p <= q) {
            if (!arr[p].equals("?") && !arr[q].equals("?") && !arr[p].equals(arr[q])) {
                return "NO";
            }
            if (arr[p].equals("?") && !arr[q].equals("?")) {
                arr[p] = arr[q];
            } else if (!arr[p].equals("?") && arr[q].equals("?")) {
                arr[q] = arr[p];
            }
            p++;
            q--;
        }
        System.out.println(Arrays.toString(arr));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString().replaceAll("\\?", "a");
    }
}
