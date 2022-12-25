package programmers.level1.햄버거_만들기;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] n = {2, 1, 1, 2, 3, 1, 2, 3, 1}; //2
//        int[] n = {1, 3, 2, 1, 2, 1, 3, 1, 2}; //0
        System.out.println(solution(n));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int j : ingredient) {
            stack.push(j);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 1
                        && stack.get(stack.size() - 3) == 2
                        && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 1) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }

            }
        }
        return answer;
    }
}
