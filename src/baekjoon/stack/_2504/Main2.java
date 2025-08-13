package baekjoon.stack._2504;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();

        if (!isValidString(input)) {
            System.out.println(0);
            return;
        }

        Element[] stack = new Element[30];
        int topIndex = -1;
        for (char ch : input) {
            int delimiterValue = delimiterToValue(ch);
            if (ch == '(' || ch == '[') {
                // push
                stack[++topIndex] = new Element(Element.Type.DELIMITER, delimiterValue);
            } else {
                int innerScore = 0;
                while (stack[topIndex].type == Element.Type.SCORE) {
                    innerScore += stack[topIndex--].value;
                }

                int score = innerScore * delimiterValue;
                if (score == 0) score = delimiterValue;
                stack[topIndex] = new Element(Element.Type.SCORE, score);
            }
        }

        int ans = 0;
        while (topIndex >= 0) {
            ans += stack[topIndex--].value;
        }
        System.out.println(ans);

    }


    static boolean isValidString(char[] str) {
        char[] stack = new char[30];
        int topIndex = -1;
        for (char ch : str) {
            if (ch == '(' || ch == '[') {
                stack[++topIndex] = ch;
            } else {
                if (topIndex < 0) return false;
                if (delimiterToValue(stack[topIndex--]) != delimiterToValue(ch)) {
                    return false;
                }
            }
        }
        return topIndex == -1;
    }

    static int delimiterToValue(char delimiter) {
        if (delimiter == '(' || delimiter == ')') {
            return 2;
        } else if (delimiter == '[' || delimiter == ']') {
            return 3;
        }
        return -1;
    }

    static class Element {
        enum Type {
            DELIMITER, SCORE
        }

        Type type;
        int value;

        public Element(Type type, int value) {
            this.type = type;
            this.value = value;
        }
    }
}
