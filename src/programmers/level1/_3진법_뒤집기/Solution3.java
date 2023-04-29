package programmers.level1._3진법_뒤집기;

public class Solution3 {
    public static void main(String[] args) {
//        int n = 45; // 7
//        int n = 125; // 229
        int n = 100000000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        String s = Integer.toString(n, 3);
        String reverse = new StringBuilder(s).reverse().toString();
        return Integer.valueOf(reverse, 3);
    }

}
