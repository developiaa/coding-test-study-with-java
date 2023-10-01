package programmers.level2.카펫;

import java.util.Arrays;

public class Solution_Review {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int b = 2 * (width + height - 2);
                int y = (width - 2) * (height - 2);

                if (brown == b && yellow == y) {
                    return new int[]{width, height};
                }
            }
        }
        return null;
    }
}
