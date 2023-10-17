package programmers.level0.A로_B만들기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
//        String before = "olleh";
//        String after = "hello"; // 1

        String before = "allpe";
        String after = "apple"; // 0
        System.out.println(solution(before, after));
    }

    public static int solution(String before, String after) {
        char[] beforeCharArray = before.toCharArray();
        char[] afterCharArray = after.toCharArray();

        Arrays.sort(beforeCharArray);
        Arrays.sort(afterCharArray);

        return new String(beforeCharArray).equals(new String(afterCharArray)) ? 1 : 0;
    }
}
