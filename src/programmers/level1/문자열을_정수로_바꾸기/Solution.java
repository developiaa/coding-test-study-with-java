package programmers.level1.문자열을_정수로_바꾸기;

public class Solution {
    public static void main(String[] args) {
        String s = "-1234"; //-1234
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        return Integer.parseInt(s);
    }
}
