package programmers.level2.최댓값과_최솟값;

public class Solution {
    public static void main(String[] args) {
//        String s = "1 2 3 4"; // 1 4
//        String s = "-1 -2 -3 -4"; // -4 -1
        String s = "-1 -1"; // -1 -1
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String[] s1 = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String value : s1) {
            if (min > Integer.parseInt(value)) {
                min = Integer.parseInt(value);
            }
            if (max < Integer.parseInt(value)) {
                max = Integer.parseInt(value);
            }
        }

        return min + " " + max;
    }
}
