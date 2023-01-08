package programmers.level1.크기가_작은_부분문자열;

public class Solution {
    public static void main(String[] args) {
//        String t = "3141592";
//        String p = "271"; // 2
//        String t = "500220839878";
//        String p = "7"; // 8
        String t = "10203";
        String p = "15"; // 3
        System.out.println(solution(t, p));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        long i2 = Long.parseLong(p);
        for (int i = 0; i <= t.length() - p.length(); i++) {
            long i1 = Long.parseLong(t.substring(i, i + p.length()));
            if (i1 <= i2) {
                answer++;
            }
        }
        return answer;
    }
}
