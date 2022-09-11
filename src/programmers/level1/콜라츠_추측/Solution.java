package programmers.level1.콜라츠_추측;

public class Solution {
    public static void main(String[] args) {
//        int n = 6; // 8
        int n = 626331; // -1
        System.out.println(solution(n));
    }

    public static int solution(int num) {
        int i = 0;
        if (num == 1) {
            return 0;
        }
        while (num != 1) {
            if (i >= 500) {
                return -1;
            }
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            i++;
        }

        return i;
    }
}
