package programmers.level2.숫자의_표현;

public class Solution {
    public static void main(String[] args) {
//        int n = 15; //4
        int n = 3; //2
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            int temp = 0;
            for (int m = i; m <= n; m++) {
                temp += m;
                if (temp > n) {
                    break;
                }
                if (temp == n) {
                    sum++;
                    break;
                }
            }
            i++;
        }
        return sum;
    }
}
