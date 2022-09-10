package programmers.level1.문자열_내림차순으로_배치하기;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        String s = "Zbcdefg"; // gfedcbZ
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String[] split = s.split("");
        Arrays.sort(split, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
        }

        return sb.toString();
    }
}
