package programmers.level1.폰켓몬;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        // 3
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            set.add(integer);
        }
        int length = nums.length / 2;
        return Math.min(set.size(), length);
    }

}
