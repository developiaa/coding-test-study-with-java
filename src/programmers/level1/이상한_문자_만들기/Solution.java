package programmers.level1.이상한_문자_만들기;

public class Solution {
    public static void main(String[] args) {
        String s = "try hello world"; // TrY HeLlO WoRlD
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // 문자열 변환으로 해결
            String a = String.valueOf(s.charAt(i));
            if (a.equals(" ")) {
                sb.append(" ");
                k = 0;
                continue;
            }

            if ((k % 2) == 0) {
                sb.append(a.toUpperCase());
            } else {
                sb.append(a.toLowerCase());
            }
            k++;
        }
        return sb.toString();
    }
}
