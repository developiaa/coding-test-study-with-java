package programmers.level1.삼총사;


public class Solution {
    public static void main(String[] args) {
//        int[] number = {-2, 3, 0, 2, -5}; //2
//        int[] number = {-3, -2, -1, 0, 1, 2, 3}; //5
        int[] number = {-1, 1, -1, 1}; //0

        System.out.println(solution(number));
    }

    public static int solution(int[] number) {
        int count = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    System.out.println(i + " " + j + " " + k);
                    if (number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
