package programmers.level1.두_정수_사이의_합;

public class Solution2 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5; // 12

        System.out.println(solution(a, b));
    }

    public static long solution(int a, int b) {
        long sum = 0;
        for (int i = Math.min(a,b); i <= Math.max(a,b); i++) {
            sum += i;
        }
        return sum;
    }
}
