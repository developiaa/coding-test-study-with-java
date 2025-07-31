package baekjoon.two_pointer._17609;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            char[] s = sc.next().toCharArray();
            int l = 0;
            int r = s.length - 1;
            int ans = 0;
            while (l <= r) {
                if (s[l] != s[r]) {
                    if (isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1)) {
                        ans = 1;
                        break;
                    } else {
                        ans = 2;
                        break;
                    }
                }
                l++;
                r--;
            }
            System.out.println(ans);
        }
    }

    public static boolean isPalindrome(char[] s, int l, int r) {
        while (l <= r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
