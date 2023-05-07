package programmers.level1.문자열_다루기_기본;

public class Solution3 {
    public static void main(String[] args) {
//        String s = "a234"; // false
//        String s = "11234"; // false
        String s = "1234"; // true
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
