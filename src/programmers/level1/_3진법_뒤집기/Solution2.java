package programmers.level1._3진법_뒤집기;

public class Solution2 {
    public static void main(String[] args) {
//        int n = 45; // 7
//        int n = 125; // 229
        int n = 100000000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        String s = Integer.toString(n, 3);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - '0') * Math.pow(3, i);
        }

        return sum;
    }

}
