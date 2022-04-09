package basic.nTest;

import java.util.Stack;

public class example {
    public static void main(String[] args) {
        //        String s = "{[()()]}"; //1
//        String s = "([)()]"; //0
//        String s = "(((((((((())))))))))(}"; //0
//        String s = "}}{{"; //0
//        String s = "(((())))(()";
//        String s = "(((((((((())))))))))()"; //1

//        String s = "(())"; // true
//        String s = "((({}))"; //false
//        String s = "()()(()){}"; //true
        String s = "((){})"; //true

        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            if (temp.equals("{") || temp.equals("(") || temp.equals("[")) {
                stack.push(temp);
            } else {
                if (!stack.isEmpty() && isBracketMatch(stack.peek(), temp)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isBracketMatch(String s1, String s2) {
        if (s1.equals("{") && s2.equals("}")) {
            return true;
        }
        if (s1.equals("(") && s2.equals(")")) {
            return true;
        }
        if (s1.equals("[") && s2.equals("]")) {
            return true;
        }
        return false;


    }
}
