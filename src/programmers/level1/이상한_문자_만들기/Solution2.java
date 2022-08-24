package programmers.level1.이상한_문자_만들기;


public class Solution2 {
    public static void main(String[] args) {
        // 짝수
        String s = "try hello world"; // TrY HeLlO WoRlD
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        // String 배열로 해결
        String[] sArr = s.split("");

        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (String s1 : sArr) {
            k = s1.contains(" ") ? 0 : k + 1;
            if ((k % 2) == 0) {
                sb.append(s1.toLowerCase());
            } else {
                sb.append(s1.toUpperCase());
            }
        }

        return sb.toString();

    }
}
