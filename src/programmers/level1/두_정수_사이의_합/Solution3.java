package programmers.level1.두_정수_사이의_합;

public class Solution3 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5; // 12

        System.out.println(solution(a, b));
    }

    public static long solution(int a, int b) {
        // 등차수열의 합 - 가장 빠름
        return (long) (Math.max(a, b) - Math.min(a, b) + 1) * (a + b) / 2;
    }
}
