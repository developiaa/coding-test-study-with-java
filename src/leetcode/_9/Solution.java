package leetcode._9;


public class Solution {
    public boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        int i = 0;
        int j = value.length() - 1;

        while (i < j) {
            char first = value.charAt(i);
            char last = value.charAt(j);

            if (first != last) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
