package programmers.level2.이진_변환_반복하기;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        String s = "110010101001"; // {3,8}
//        String s = "01110"; // {3,3}
//        String s = "1111111"; // {4,1}
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int loop = 0;
        int removed = 0;

        while (!s.equals("1")) {
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;

            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }


        return new int[]{loop, removed};
    }

    public static int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            }
        }
        return zeros;
    }

}
