package programmers.test.n2506;

public class Solution2_2 {
    public static void main(String[] args) {
        System.out.println(solution(3, 1, 0));
        System.out.println(solution(1, 4, 4));
        System.out.println(solution(1, 3, 0));
        System.out.println(solution(3, 1, 3));

    }


     static String solution(int A, int B, int C) {
        StringBuilder result = new StringBuilder();
        int a = A, b = B, c = C;
        String last = "", lastLast = "";

        while (a > 0 || b > 0 || c > 0) {
            if (a > 0 && !(last.equals("a") && lastLast.equals("a"))) {
                if (addable(b, a + c - 1) && addable(c, a + b - 1)) {
                    result.append("a");
                    a--;
                    lastLast = last;
                    last = "a";
                    continue;
                }
            }

            if (b > 0 && !(last.equals("b") && lastLast.equals("b"))) {
                if (addable(a, b + c - 1) && addable(c, a + b - 1)) {
                    result.append("b");
                    b--;
                    lastLast = last;
                    last = "b";
                    continue;
                }
            }

            if (c > 0 && !(last.equals("c") && lastLast.equals("c"))) {
                if (addable(a, b + c - 1) && addable(b, a + c - 1)) {
                    result.append("c");
                    c--;
                    lastLast = last;
                    last = "c";
                    continue;
                }
            }

            break;
        }

        return result.toString();
    }

    public static boolean addable(int x, int other) {
        return other >= (int) Math.ceil(x / 2.0) - 1;
    }



}
