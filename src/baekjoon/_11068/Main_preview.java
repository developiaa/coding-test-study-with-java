package baekjoon._11068;

import java.util.Scanner;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        for (int a = 0; a < N; a++) {
            int num2 = sc.nextInt();
            int check = 0;
            for (int i = 2; i <= 64; i++) {
                String answer = "";
                int num = num2;
                while (num > 0) {
                    int digit = num % i;
                    if (digit < 10) answer += digit;
                    else answer += (char) ('A' + digit - 10);
                    num /= i;
                }

                if (!answer.equals("") && isPalindrome(answer)) {
                    check = 1;
                    break;
                }
            }

            System.out.println(check);
        }
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
