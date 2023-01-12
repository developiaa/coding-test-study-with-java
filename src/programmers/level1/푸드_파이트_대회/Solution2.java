package programmers.level1.푸드_파이트_대회;

public class Solution2 {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};//1223330333221
//        int[] food = {1, 7, 1, 2};//111303111
        System.out.println(solution(food));
    }

    public static String solution(int[] food) {
        String answer = "0";
        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i;
            }
        }
        return answer;
    }
}
