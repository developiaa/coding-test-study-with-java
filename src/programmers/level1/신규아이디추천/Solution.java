package programmers.level1.신규아이디추천;

public class Solution {
    public static void main(String[] args) {
//        String id = "...!@BaT#*..y.abcdefghijklm";
        String id = "z-+.^.";
//        String id = "abcdefghijklmn.p";
//        String id = "=.=";
        System.out.println(solution(id));
    }

    public static String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (c >= 65 && c <= 90) {
                sb.append((char) (c + 32));
                continue;
            }

            if (c >= 97 && c <= 122) {
                // 소문자의 경우
                sb.append(c);
                continue;
            }

            if (c >= 48 && c <= 57) {
                // 숫자인 경우
                sb.append(c);
                continue;
            }
            if (c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        // 3단계
        int pointCheck = 0;
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '.') {
                pointCheck++;
                continue;
            }
            if (pointCheck >= 1) {
                sb2.append('.');
            }

            pointCheck = 0;
            sb2.append(c);
        }

        // 4단계
        StringBuilder sb3 = new StringBuilder();
        for (int i = 0; i < sb2.length(); i++) {
            char c = sb2.toString().charAt(i);
            if (i == 0 && c == '.') {
                continue;
            }
            if (i == sb2.length() - 1 && c == '.') {
                continue;
            }
            sb3.append(c);
        }


        StringBuilder s = new StringBuilder(sb3.toString());
        if (s.toString().equals("")) {
            s = new StringBuilder("a");
        }

        if (s.length() >= 16) {
            s = new StringBuilder(s.substring(0, 15));
            if (s.charAt(14) == '.') {
                s = new StringBuilder(s.substring(0, 14));
            }
        }

        if (s.length() <= 2) {
            char c = s.charAt(s.length() - 1);
            while (s.length() < 3) {
                s.append(c);
            }
        }

        return s.toString();
    }
}
