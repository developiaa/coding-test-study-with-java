package programmers.level1.이상한_문자_만들기;


public class Solution3 {
    public static void main(String[] args) {
        // 짝수
        String s = "try hello world"; // TrY HeLlO WoRlD
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                //공백 처리
                builder.append(c);
                toUpper = true;
            } else {
                //문자 처리
                if (toUpper) {
                    // 대문자 처리
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return builder.toString();
    }

}
