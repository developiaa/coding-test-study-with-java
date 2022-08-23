package programmers.level1.하샤드_수;

public class Solution {
    public static void main(String[] args) {
//        int x = 10; // true
//        int x = 12; // true
//        int x = 11; // false
        int x = 13; // false
        System.out.println(solution(x));

    }

    public static boolean solution(int x) {
        String s = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += (c - '0');
        }
        return x % sum == 0;
    }
}
