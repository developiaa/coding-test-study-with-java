package programmers.level1.평균_구하기;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        // 2.5
        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        double answer = 0;
        for (int i : arr) {
            answer += i;
        }
        return answer/arr.length;
    }
}
