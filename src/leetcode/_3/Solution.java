package leetcode._3;

public class Solution {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[128];
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, charIndex[c]);
            max = Math.max(max, right - left + 1);
            charIndex[c] = right + 1;
        }

        return max;
    }
}
