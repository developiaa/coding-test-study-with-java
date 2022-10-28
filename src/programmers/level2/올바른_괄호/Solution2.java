package programmers.level2.올바른_괄호;

import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
//        String s = "()()"; //true
//        String s = "(())()"; //true
        String s = ")()("; //false
//        String s = "(()("; //false

        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }

            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
