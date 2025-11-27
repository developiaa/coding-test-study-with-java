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
            // 1. 오래된 인덱스 제거 (Clean Up Left)
            // Deque 맨 앞의 인덱스가 현재 윈도우의 왼쪽 경계(i - k)를 벗어났다면 제거
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }

            // 2. 작은 값 제거 (Clean Up Right)
            // 현재 nums[i]보다 작거나 같은 값들은 앞으로 최대값이 될 가능성이 없으므로 제거
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }

            // 3. 현재 인덱스 추가
            deque.addLast(i);

            // 4. 결과 기록 (윈도우가 k 크기에 도달했을 때부터)
            if (i >= k - 1) {
                // Deque의 맨 앞 인덱스에 해당하는 값이 현재 윈도우의 최대값
                answer[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return answer;
    }
}
