package programmers.level1.정수_내림차순으로_배치하기;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        long n = 118372; // 873211
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        String[] split = String.valueOf(n).split("");
        // 기본은 오름차순
        Arrays.sort(split, Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append(s);
        }
        return Long.parseLong(stringBuilder.toString());
    }
}
