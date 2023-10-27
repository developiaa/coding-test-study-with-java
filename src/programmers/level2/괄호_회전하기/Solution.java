package programmers.level2.괄호_회전하기;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "[](){}"; //3
//        String s = "}]()[{"; //2
//        String s = "[)(]"; //0
//        String s = "}}}"; //0
        System.out.println(solution(s));
    }

    // [](){} o
    // ](){}[ x
    // (){}[] 0
    // ){}[]( x
    // {}[]() 0
    // }[](){ x

    public static int solution(String s) {
        int answer = 0;

        String[] strings = changeString(s);
        for (String string : strings) {
            if (isCorrect(string)) {
                answer++;
            }
        }
        return answer;
    }

    public static String[] changeString(String s) {
        String[] arr = new String[s.length()];
//        arr[0] = s.charAt(0) + ... s.charAt(5);
//        arr[1] = s.charAt(1) + ...s.charAt(5) + s.charAt(0);
//        arr[2] = s.charAt(2) + ...s.charAt(5) + s.charAt(0)+s.charAt(1);
//
//        arr[i] = s.charAt(i) + ..s.charAt(s.length() - 1) + s.charAt(i - 1) + s.charAt(i - 2);

        for (int i = 0; i < arr.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                stringBuilder.append(s.charAt(j));
            }

            if (i >= 1) {
                for (int k = 0; k < i; k++) {
                    stringBuilder.append(s.charAt(k));
                }
            }

            arr[i] = stringBuilder.toString();
        }
        return arr;
    }

    public static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (!hasMatch(String.valueOf(pop), String.valueOf(c))) {
                        return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static boolean hasMatch(String s1, String s2) {
        if (s1.equals("[") && s2.equals("]")) {
            return true;
        }
        if (s1.equals("(") && s2.equals(")")) {
            return true;
        }

        if (s1.equals("{") && s2.equals("}")) {
            return true;
        }
        return false;
    }

}
