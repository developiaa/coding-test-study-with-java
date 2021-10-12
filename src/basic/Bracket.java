package basic;

import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
//        String s = "{(a)}b"; // true
//        String s = "{(ab})"; // false
        String s = "{(ab){}}"; // true
        System.out.println(isTrue(s));
    }

    public static boolean isTrue(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            System.out.println(stack);
            if(stack.size()==0){
                continue;
            }
            if (stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            }
            if (stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
            }

        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }

    }


}
