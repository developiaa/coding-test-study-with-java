package leetcode._26;


public class Solution {
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[insertIndex - 1] != nums[i]) {
                nums[insertIndex++] = nums[i];
            }
        }
        return insertIndex;
    }
}
