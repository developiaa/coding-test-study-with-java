package codility.lesson7;

import java.util.Stack;

public class Nesting {
    public static void main(String[] args) {
//        String s = "(()(())())";    //1
//        String s = "((()())";    //0
        String s = ")()";    //0

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(c);
            }

            if (c == ')') {
                if (stack.size() != 0 && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    return 0;
                }
            }
            System.out.println(stack);
        }
        if (stack.size() != 0) {
            return 0;
        }
        return 1;
    }
}
