package programmers.level2.뒤에_있는_큰_수_찾기;

import java.util.Arrays;

@Deprecated(since = "시간 초과")
public class Solution {
    public static void main(String[] args) {
//        int[] number = {2, 3, 3, 5}; //[3,5,5,-1]
        int[] number = {9, 1, 5, 3, 6, 2}; //[-1, 5, 6, 6, -1, -1]

        System.out.println(Arrays.toString(solution(number)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int temp = -1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    temp = numbers[j];
                    break;
                }
            }
            answer[i] = temp;
        }

        return answer;
    }
}
