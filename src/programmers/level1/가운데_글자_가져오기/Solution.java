package programmers.level1.가운데_글자_가져오기;

public class Solution {
    public static void main(String[] args) {
//        String s = "abcde"; // c
//        String s = "aabbcc"; // bb
        String s = "qwer"; // we
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        if (s.length() % 2 == 0) {
            return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            return String.valueOf(s.charAt(s.length() / 2));
        }
    }
}
