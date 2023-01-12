package programmers.level1.푸드_파이트_대회;

public class Solution {
    public static void main(String[] args) {
//        int[] food = {1, 3, 4, 6};//1223330333221
        int[] food = {1, 7, 1, 2};//111303111
        System.out.println(solution(food));
    }

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int i1 = food[i] / 2;
            for (int k = 1; k <= i1; k++) {
                sb.append(i);
            }
        }
        sb.append(0);
        for (int i = sb.toString().length() - 2; i >= 0; i--) {
            sb.append(sb.toString().charAt(i));
        }

        return sb.toString();
    }
}
