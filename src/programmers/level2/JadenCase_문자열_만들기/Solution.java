package programmers.level2.JadenCase_문자열_만들기;

public class Solution {
    public static void main(String[] args) {
        String s = "3people unFollowed me"; // 3people Unfollowed Me
//        String s = "for the last week"; // For The Last Week
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        int temp = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                temp = 0;
                stringBuilder.append(" ");
                continue;
            }

            if (temp == 0) {
                stringBuilder.append(String.valueOf(s.charAt(i)).toUpperCase());
                temp++;
            } else {
                stringBuilder.append(String.valueOf(s.charAt(i)).toLowerCase());
            }

        }
        return stringBuilder.toString();
    }
}
