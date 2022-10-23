package programmers.level2.카펫;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int brown = 10;
//        int yellow = 2; //{4,3}

//        int brown = 8;
//        int yellow = 1; //{3,3}

        int brown = 24;
        int yellow = 24; //{8,6}

        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int width = 0;
        int height = 0;
        for (int i = 1; i <= total; i++) {
            int temp;
            if (total % i == 0) {
                temp = total / i;
                if (2 * i + 2 * temp - 4 == brown) {
                    width = Math.max(i, temp);
                    height = Math.min(i, temp);
                }
            }
        }
        return new int[]{width, height};
    }
}
