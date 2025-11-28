package leetcode._42;

/**
 * Trapping Rain Water
 */
public class Solution {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6
//        int[] height = {4,2,0,3,2,5}; // 9

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // 빗물이 고이려면 최소 3개의 벽이 필요합니다.
        }

        int left = 0;
        int right = height.length - 1;
        int totalWater = 0;

        // 왼쪽과 오른쪽에서 현재까지의 최대 높이를 저장합니다.
        int leftMax = 0;
        int rightMax = 0;

        // 투 포인터가 만날 때까지 반복합니다.
        while (left < right) {
            // 현재 왼쪽 포인터의 높이가 오른쪽 포인터의 높이보다 낮은 경우,
            // 빗물의 양은 leftMax에 의해 결정됩니다. (rightMax는 이미 height[left]보다 크거나 같음이 보장됨)
            if (height[left] < height[right]) {

                // 1. leftMax 갱신
                if (height[left] >= leftMax) {
                    // 현재 벽이 이전 최대 벽보다 높으면 빗물은 고이지 않고 leftMax를 갱신합니다.
                    leftMax = height[left];
                } else {
                    // 현재 벽이 leftMax보다 낮으면 빗물이 고입니다.
                    // 고이는 물의 양: min(leftMax, rightMax) - height[left]
                    // (여기서는 leftMax가 min 역할을 합니다.)
                    totalWater += leftMax - height[left];
                }
                left++; // 왼쪽 포인터를 오른쪽으로 이동

            }
            // 현재 오른쪽 포인터의 높이가 왼쪽 포인터의 높이보다 낮거나 같은 경우,
            // 빗물의 양은 rightMax에 의해 결정됩니다.
            else {

                // 1. rightMax 갱신
                if (height[right] >= rightMax) {
                    // 현재 벽이 이전 최대 벽보다 높으면 빗물은 고이지 않고 rightMax를 갱신합니다.
                    rightMax = height[right];
                } else {
                    // 현재 벽이 rightMax보다 낮으면 빗물이 고입니다.
                    // 고이는 물의 양: min(leftMax, rightMax) - height[right]
                    // (여기서는 rightMax가 min 역할을 합니다.)
                    totalWater += rightMax - height[right];
                }
                right--; // 오른쪽 포인터를 왼쪽으로 이동
            }
        }

        return totalWater;
    }

}
