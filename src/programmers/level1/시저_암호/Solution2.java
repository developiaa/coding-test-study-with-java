package programmers.level1.시저_암호;

public class Solution2 {
    public static void main(String[] args) {
//        String s = "AB";
//        int n = 1; // "BC"
        String s = "a B z";
        int n = 4; // "e F d"
        System.out.println(solution(s, n));
    }

    public static String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(push(c, n));
        }

        return builder.toString();
    }

    // c를 n민 만큼 반환
    private static char push(char c, int n) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }
}
