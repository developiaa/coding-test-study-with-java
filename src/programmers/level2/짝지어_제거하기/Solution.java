package programmers.level2.짝지어_제거하기;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "baabaa"; //1
//        String s = "baacaa"; //0
//        String s = "baaaab"; //1
//        String s = "cdcd"; //0
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
