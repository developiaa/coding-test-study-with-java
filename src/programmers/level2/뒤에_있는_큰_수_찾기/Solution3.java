package programmers.level2.뒤에_있는_큰_수_찾기;

import java.util.Arrays;
import java.util.Stack;

public class Solution3 {
    public static void main(String[] args) {
//        int[] number = {2, 3, 3, 5}; //[3,5,5,-1]
        int[] number = {9, 1, 5, 3, 6, 2}; //[-1, 5, 6, 6, -1, -1]

        System.out.println(Arrays.toString(solution(number)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                int index = stack.pop();
                if (numbers[index] < numbers[i]) {
                    // 뒤에 값이 더 크면 앞에 값에 뒤에 큰수를 입력
                    answer[index] = numbers[i];
                } else {
                    // 앞에 값이 더 크거나 같은 경우 다시 넣는다.
                    stack.push(index);
                    break;
                }
            }
            stack.push(i);
        }


        return answer;
    }
}
