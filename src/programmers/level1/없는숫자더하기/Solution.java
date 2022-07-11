package programmers.level1.없는숫자더하기;

public class Solution {
    public static void main(String[] args) {
//        int[] number = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] number = {5, 8, 4, 0, 6, 7, 9};
        System.out.println(solution(number));
    }

    public static int solution(int[] number) {
        int sum = 0;
        for (int i : number) {
            sum += i;
        }

        return 45 - sum;
    }
}
