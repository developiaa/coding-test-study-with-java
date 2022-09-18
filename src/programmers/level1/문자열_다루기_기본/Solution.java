package programmers.level1.문자열_다루기_기본;

public class Solution {
    public static void main(String[] args) {
//        String s = "a234"; // false
        String s = "1234"; // true
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
//                return false;
//            }
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
