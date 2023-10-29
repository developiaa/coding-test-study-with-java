package programmers.level2.주식가격;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3}; // 4, 3, 1, 1, 0
        System.out.println(Arrays.toString(solution(prices)));

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }
}
