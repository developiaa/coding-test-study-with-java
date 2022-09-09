package programmers.level1.두_정수_사이의_합;

public class Solution {
    public static void main(String[] args) {
        int a = 3;
        int b = 5; // 12

        System.out.println(solution(a, b));
    }

    public static long solution(int a, int b) {
        if (a == b) {
            return a;
        }
        int temp = 0;

        if (a < b) {
            temp = b;
            b = a;
            a = temp;
        }

        long sum = 0;
        for (int i = b; i <= a; i++) {
            sum += i;
        }


        return sum;
    }
}
