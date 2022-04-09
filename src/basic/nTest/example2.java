package basic.nTest;


public class example2 {
    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int p = 0;
        int q = s.length() - 1;

        while (p < q) {
            if (s.charAt(p) != s.charAt(q)) {
                return false;
            }
            p++;
            q--;
        }

        return true;
    }
}