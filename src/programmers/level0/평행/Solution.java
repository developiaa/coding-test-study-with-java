package programmers.level0.평행;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}}; //1
        System.out.println(solution(dots));

    }

    public static int solution(int[][] dots) {
        Set<Double> slopes = new HashSet<>();
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[i][1],
                        dots[j][0], dots[j][1]);
                if (slopes.contains(slope)) {
                    return 1;
                }
                slopes.add(slope);
            }
        }
        return 0;
    }

    public static double getSlope(int x1, int y1, int x2, int y2) {
        return Math.abs((double) (y2 - y1) / (x2 - x1));
    }
}
