package programmers.level2.문자열_압축;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
//        String s = "aabbaccc"; // 7
//        String s = "ababcdcdababcdcd"; // 9
//        String s = "abcabcdede"; // 8
        String s = "abcabcabcabcdededededede"; // 14
//        String s = "xababcdcdababcdcd"; // 17
        System.out.println(solution(s));
//        System.out.println(convert(s));
    }

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            int compressed = compress(s, i);
            if (min > compressed) {
                min = compressed;
            }
        }

        return min;
    }

    private static int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            // 압축 문자열
            if (token.equals(last)) {
                // 이전 토큰과 같은 경우
                count++;
            } else {
                // 새로운 토큰
                if (count > 1) {
                    // 2이상일 경우 숫자 넣음
                    builder.append(count);
                }
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) {
            builder.append(count);
        }
        builder.append(last);

        return builder.length();
    }

    private static List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex+=length) {
            int endIndex = startIndex + length;
            if (endIndex > source.length()) {
                endIndex = source.length();
            }
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }
}
