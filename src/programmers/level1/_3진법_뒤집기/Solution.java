package programmers.level1._3진법_뒤집기;

// 메모리 초과로 일부 실패
public class Solution {
    public static void main(String[] args) {
        int n = 45; // 7
//        int n = 125; // 229
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        StringBuilder sb = new StringBuilder();
        // 이 부분 메모리 초과
        while (true) {
            sb.append(n % 3);
            if (n == 1) {
                break;
            }
            n = n / 3;
        }

        int sum = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int i1 = sb.charAt(i) - '0';
            double i2 = Math.pow(3, sb.length() - 1 - i);
            sum += i1 * i2;
        }
        return sum;
    }

}
