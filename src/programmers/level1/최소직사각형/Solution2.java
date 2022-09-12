package programmers.level1.최소직사각형;

public class Solution2 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}; // 4000
//        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}; // 120
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int max = 0;
        int min = 0;

        for (int[] size : sizes) {
            int tempMax = Math.max(size[0], size[1]);
            int tempMin = Math.min(size[0], size[1]);

            if (max < tempMax) {
                max = tempMax;
            }

            if (min < tempMin) {
                min = tempMin;
            }
        }

        return max * min;
    }
}
