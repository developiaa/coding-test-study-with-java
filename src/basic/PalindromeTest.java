package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeTest {
    public static void main(String[] args) {
        //abcdcba
//        String test = "??cd?ba";
//        String test = "?a?";
//        String test = "?ca?a?b";
        String test = "??cca?b";
        System.out.println(Palindrome(test));
    }

    public static String Palindrome(String string) {
        int p = 0;
        int q = string.length() - 1;
        String[] temp = new String[string.length()];
        boolean isPalindrome = true;
        String result = "";

        while (p <= q) {
            if (string.charAt(p) == '?' && string.charAt(q) != '?') {
                temp[p] = String.valueOf(string.charAt(q));
                temp[q] = String.valueOf(string.charAt(q));
            }
            if (string.charAt(p) != '?' && string.charAt(q) == '?') {
                temp[p] = String.valueOf(string.charAt(p));
                temp[q] = String.valueOf(string.charAt(p));
            }
            if (string.charAt(p) == '?' && string.charAt(q) == '?') {
                temp[p] = "a";
                temp[q] = "a";
            }

            if (string.charAt(p) != '?' && string.charAt(q) != '?') {
                if (string.charAt(p) != string.charAt(q)) {
                    isPalindrome = false;
                    break;
                }
                temp[p] = String.valueOf(string.charAt(p));
                temp[q] = String.valueOf(string.charAt(q));
            }
            if (p == q) {
                if (string.charAt(p) == '?') {
                    temp[p] = "a";
                } else {
                    temp[p] = String.valueOf(string.charAt(p));
                }
            }
            p++;
            q--;
        }
        System.out.println(Arrays.toString(temp));
        if (isPalindrome) {
            for (int i = 0; i < temp.length; i++) {
                result += temp[i];
            }
        } else {
            result = "null";
        }
        return result;
    }
}
