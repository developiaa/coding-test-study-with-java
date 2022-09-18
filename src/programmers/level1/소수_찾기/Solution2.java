package programmers.level1.소수_찾기;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
//        int n = 10; // 4
        int n = 1000000; // 78498
//        int n = 5; //3
        System.out.println(solution(n));
    }

    // 에라토스테네스의 체
    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
//        System.out.println(Arrays.toString(arr));

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 1) continue; // 1인 경우 소수가 아니므로 루프 제외한다.
            for (int j = i + i; j <= n; j += i) {
                // 배수를 순회하여 1로 만든다.
                // 1인 경우 소수가 아니다
                arr[j] = 1;
            }
            answer++;
        }

        return answer;
    }

}



