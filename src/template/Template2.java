package template;

import java.util.Stack;

/**
 * 주어진 괄호가 올바른 괄호인지 확인
 */
public class Template2 {
    public static boolean isCorrectBracket(char[] str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != str[i]) return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isCorrectBracket(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            char c = str[(offset + i) % str.length];
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
