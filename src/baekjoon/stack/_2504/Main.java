package baekjoon.stack._2504;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();

        Element[] stack = new Element[30];
        int topIndex = -1;
        for (char ch : input) {
            int delimiterValue = delimiterToValue(ch);
            if (ch == '(' || ch == '[') {
                // push
                stack[++topIndex] = new Element(Element.Type.DELIMITER, delimiterValue);
            } else {
                int innerScore = 0;
                while (topIndex >= 0 && stack[topIndex].type == Element.Type.SCORE) {
                    innerScore += stack[topIndex--].value;
                }

                if (topIndex < 0 || stack[topIndex].value != delimiterValue) {
                    // notValid
                    System.out.println(0);
                    return;
                }

                int score = innerScore * delimiterValue;
                if (score == 0) score = delimiterValue;
                stack[topIndex] = new Element(Element.Type.SCORE, score);
            }
        }

        int ans = 0;
        while (topIndex >= 0) {
            if (stack[topIndex].type == Element.Type.DELIMITER) {
                System.out.println(0);
                return;
            }
            ans += stack[topIndex--].value;
        }
        System.out.println(ans);

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
