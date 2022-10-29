package programmers.level2.이진_변환_반복하기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        String s = "110010101001"; // {3,8}
//        String s = "01110"; // {3,3}
        String s = "1111111"; // {4,1}
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                    count++;
                }
            }
            s = Integer.toBinaryString(s.length() - count);
            answer[0]++;
        }
        return answer;
    }

}
