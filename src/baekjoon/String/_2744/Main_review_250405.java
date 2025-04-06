package baekjoon.String._2744;

import java.util.Scanner;

public class Main_review_250405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('A' <= c && c <= 'Z') {
                // 대문자인 경우 소문자로 변경
                sb.append((char)(c - 'A' + 'a'));
            } else {
                sb.append((char)(c - 'a' + 'A'));
            }
        }
        System.out.println(sb.toString());
    }
}
