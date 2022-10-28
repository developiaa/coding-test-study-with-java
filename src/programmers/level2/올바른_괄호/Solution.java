package programmers.level2.올바른_괄호;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        String s = "()()"; //true
//        String s = "(())()"; //true
//        String s = ")()("; //false
        String s = "(()("; //false

        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    //비어있는데 넣으면 에러
                    return false;
                }
                if (stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
