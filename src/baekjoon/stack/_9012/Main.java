package baekjoon.stack._9012;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int openCount = 0;
            char[] input = sc.next().toCharArray();
            for (char ch : input) {
                if (ch == '(')
                    openCount++;
                else if (ch == ')') {
                    openCount--;
                    if (openCount < 0)
                        break;
                }
            }

            if (openCount == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
