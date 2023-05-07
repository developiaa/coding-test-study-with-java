package programmers.level1.문자열_다루기_기본;

public class Solution2 {
    public static void main(String[] args) {
//        String s = "a234"; // false
        String s = "11234"; // false
//        String s = "1234"; // true
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
    }
}
