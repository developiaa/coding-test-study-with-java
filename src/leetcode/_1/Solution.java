package leetcode._1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int answer = -1;
        int complement = -1;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                answer = i;
                break;
            }

            numMap.put(nums[i], i);
        }
        return new int[]{numMap.get(complement), answer};
    }

}
