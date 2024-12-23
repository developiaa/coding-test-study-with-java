package programmers.level2.괄호_회전하기;

import java.util.Stack;

public class Solution2_review {
    public static void main(String[] args) {
        String s = "[](){}"; //3
//        String s = "}]()[{"; //2
//        String s = "[)(]"; //0
//        String s = "}}}"; //0
        System.out.println(solution(s));
    }

    // 왼쪽
    // [](){} o
    // ](){}[ x
    // (){}[] 0
    // ){}[]( x
    // {}[]() 0
    // }[](){ x

    // 오른쪽
    // [](){} o
    // }[](){ x
    // {}[]() o
    // ){}[]( x
    // (){}[] o
    // ](){}[ x

    // (()){}

    // (    )
    // ((   ))
    // (()  )
    // (())

    public static int solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for (int offset = 0; offset < str.length; offset++) {
            if (isCorrect(str, offset)) {
                count++;
            }
        }

        return count;
    }

    // 하나의 문자열에 대해서 괄호가 올바르게 구성 되어 있는지 확인
    public static boolean isCorrect(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            char c = str[(offset + i) % str.length];
            switch (c) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                case ')', ']', '}' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
