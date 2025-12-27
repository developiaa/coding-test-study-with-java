package leetcode._58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                count++;
            }

            if (i - 1 >= 0 && c != ' ' && s.charAt(i - 1) == ' ') {
                break;
            }
        }

        return count;
    }

    public int lengthOfLastWord2(String s) {
        int n = s.length();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                count++;
            } else {
                if (count > 0) {
                    return count;
                }
            }
        }

        return count;
    }
}
