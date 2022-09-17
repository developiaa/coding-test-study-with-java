package programmers.level1.최대공약수와_최소공배수;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int n = 3;
//        int m = 12; // {3,12}

//        int n = 2;
//        int m = 5; // {1,10}

        int n = 4;
        int m = 6; // {2, 12}
        System.out.println(Arrays.toString(solution(n, m)));
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        int a = 0;
        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                if (a < i) {
                    a = i;
                }
            }
        }
        answer[0] = a;
        answer[1] = a * (n / a) * (m / a);


        return answer;
    }

}
