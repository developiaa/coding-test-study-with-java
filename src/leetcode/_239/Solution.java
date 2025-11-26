package leetcode._239;

import java.util.*;

/**
 * Sliding Window Maximum
 * Output: [3, 3, 5, 5, 6, 7]
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        int resultIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
            if (i >= k - 1) {
                answer[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return answer;
    }
}
