package leetcode._42;


public class Review {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6
//        int[] height = {4, 2, 0, 3, 2, 5}; // 9

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMaxValue = 0;
        int rightMaxValue = 0;
        int answer = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMaxValue) {
                    leftMaxValue = height[left];
                } else {
                    answer += leftMaxValue - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMaxValue) {
                    rightMaxValue = height[right];
                } else {
                    answer += rightMaxValue - height[right];
                }
                right--;
            }
        }
        return answer;
    }
}
