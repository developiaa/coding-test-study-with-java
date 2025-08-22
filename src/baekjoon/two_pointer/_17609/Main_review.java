package baekjoon.two_pointer._17609;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            char[] ch = sc.next().toCharArray();
            int l = 0;
            int r = ch.length - 1;

            int type = 0;
            while (l < r) {
                if (ch[l] != ch[r]) {
                    if (isPalindrome(ch, l + 1, r) || isPalindrome(ch, l, r - 1)) {
                        type = 1;
                        break;
                    } else {
                        type = 2;
                        break;
                    }

                } else {
                    l++;
                    r--;
                }
            }

            System.out.println(type);

        }
    }

    public static boolean isPalindrome(char[] ch, int l, int r) {
        while (l < r) {
            if (ch[l] != ch[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

