package programmers.level2.카펫;

import java.util.Arrays;

public class Solution2 {
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
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int boundary = (width + height - 2) * 2;
                int center = width * height - boundary;

                if (brown == boundary && yellow == center) {
                    return new int[]{width, height};
                }
            }
        }
        return null;
    }
}
