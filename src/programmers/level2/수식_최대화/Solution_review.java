package programmers.level2.수식_최대화;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_review {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20"; //60420
//        String expression = "50*6-3*2"; //300
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        StringTokenizer stringTokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> list = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            list.add(stringTokenizer.nextToken());
        }
        System.out.println(list);

        long max = 0;
        for (String[] order : precedence) {
            long value = Math.abs(count(new ArrayList<>(list), order));
            max = Math.max(max, value);
        }

        return max;
    }

    public static long count(List<String> expression, String[] order) {
        for (String string : order) {
            for (int i = 0; i < expression.size(); i++) {
                if (string.equals(expression.get(i))) {
                    long left = Long.parseLong(expression.get(i - 1));
                    long right = Long.parseLong(expression.get(i + 1));
                    long value = count(left, right, string);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.add(i-1, String.valueOf(value));
                    i -=2;
                }
            }
        }

        return Long.parseLong(expression.get(0));
    }

    public static long count(long left, long right, String operation) {
        return switch (operation) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> 0;
        };
    }


    public static String[][] precedence = {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split(""),
    };

}
