package programmers.level1.시저_암호;

public class Solution {
    public static void main(String[] args) {
//        String s = "AB";
//        int n = 1; // "BC"
        String s = "a B z";
        int n = 4; // "e F d"
        System.out.println(solution(s, n));
    }

    public static String solution(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                // 공백인 경우
                c = ' ';
            } else {
                if (c >= 65 && c <= 90) {
                    // 대문자
                    if (c + n > 90) {
                        c = (char) (c + n - 26);
                    } else {
                        c += n;
                    }
                } else if (c >= 97 && c <= 122) {
                    // 소문자
                    if (c + n > 122) {
                        c = (char) (c + n - 26);
                    } else {
                        c += n;
                    }
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
