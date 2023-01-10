package programmers.level1.기사단원의_무기;

// 시간초과
public class Solution2 {
    public static void main(String[] args) {
//        int number = 5;
//        int limit = 3;
//        int power = 2; // 10
        int number = 10;
        int limit = 3;
        int power = 2; // 21
        System.out.println(solution(number, limit, power));
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        // 약수의 개수
        for (int i = 1; i <= number; i++) {
            int temp = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    temp++;
                } else if (i % j == 0) {
                    temp += 2;
                }
            }

            if (temp > limit) {
                temp = power;
            }
            answer += temp;
        }
        return answer;
    }
}
