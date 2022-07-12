package programmers.level1.음양더하기;

public class Solution {
    public static void main(String[] args) {
//        int[] absolutes = {4, 7, 12};
//        boolean[] signs = {true, false, true};
        int[] absolutes = {1, 2, 3};
        boolean[] signs = {false, false, true};
        System.out.println(solution(absolutes, signs));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                sum += absolutes[i];
            } else {
                sum -= absolutes[i];
            }
        }
        return sum;
    }
}
