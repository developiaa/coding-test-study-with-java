package programmers.level1.숫자_짝꿍;

public class Solution2 {
    public static void main(String[] args) {
        String X = "100";
        String Y = "2345";// -1
//        String X = "100";
//        String Y = "203045";// 0
//        String X = "100";
//        String Y = "123450";// 10
//        String X = "12321";
//        String Y = "42531";// 321
//        String X = "5525";
//        String Y = "1255";// 552
        System.out.println(solution(X, Y));
    }

    public static String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] x = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] y = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < X.length(); i++) {
            x[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            y[Y.charAt(i) - '0']++;
        }

        for (int i = x.length - 1; i >= 0; i--) {
            for (int j = 0; j < Math.min(x[i], y[i]); j++) {
                sb.append(i);
            }
        }
        if (sb.toString().equals("")) {
            return "-1";
        } else if (sb.toString().charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }

}
