package programmers.level2.N개의_최소공배수;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {2, 6, 8, 14}; // 168
//        int[] arr = {1, 2, 3}; // 6
        int[] arr = {4, 6, 8}; // 24
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd;
        }

        return answer;
    }

    // 최대 공약수
    public static int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);

        while (x % y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return y;
    }
}
