package programmers.level2.JadenCase_문자열_만들기;

public class Solution2 {
    public static void main(String[] args) {
        String s = "3people unFollowed me"; // 3people Unfollowed Me
//        String s = "for the last week"; // For The Last Week
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String[] s1 = s.toLowerCase().split("");
        StringBuilder answer = new StringBuilder();
        boolean flag = true;
        for (String value : s1) {
            answer.append(flag ? value.toUpperCase() : value);
            flag = value.equals(" ");
        }
        return answer.toString();
    }
}
