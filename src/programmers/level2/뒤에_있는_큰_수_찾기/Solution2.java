package programmers.level2.뒤에_있는_큰_수_찾기;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
//        int[] number = {2, 3, 3, 5}; //[3,5,5,-1]
        int[] number = {9, 1, 5, 3, 6, 2}; //[-1, 5, 6, 6, -1, -1]

        System.out.println(Arrays.toString(solution(number)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty() || numbers[i] < numbers[i - 1]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
