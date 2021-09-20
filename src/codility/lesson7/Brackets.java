package codility.lesson7;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
//        String s = "{[()()]}"; //1
//        String s = "([)()]"; //0
//        String s = "(((((((((())))))))))(}"; //0
//        String s = "}}{{"; //0
        String s = "(((())))(()";
//        String s = "(((((((((())))))))))()"; //1
        System.out.println(solution(s));
    }

    public static int solution(String S) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            String temp = String.valueOf(S.charAt(i));
            System.out.println(stack);
            if (temp.equals("{") || temp.equals("(") || temp.equals("[")) {
                stack.push(String.valueOf(S.charAt(i)));
            } else {
                if (!stack.isEmpty() && isBracketMatch(stack.peek(), temp)) {
                    stack.pop();
                } else {
                    return 0;
                }
            }
        }
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

    public static Boolean isBracketMatch(String s1, String s2) {
        if (s1.equals("(") && s2.equals(")")) {
            return true;
        }
        if (s1.equals("{") && s2.equals("}")) {
            return true;
        }
        if (s1.equals("[") && s2.equals("]")) {
            return true;
        }
        return false;
    }

}
