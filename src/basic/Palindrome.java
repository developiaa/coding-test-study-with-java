package basic;

public class Palindrome {

    public static void main(String[] args) {
        String test = "abcdcba";
        System.out.println(isPalindrome(test));
    }

    public static boolean isPalindrome(String string) {
        int p = 0;
        int q = string.length() - 1;
        while (p < q) {
            if (string.charAt(p) != string.charAt(q)) {
                return false;
            }
            p += 1;
            q -= 1;
        }
        return true;

    }

}
