package baekjoon.String._2744;

import java.util.Scanner;

public class Main_review4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);
            if ('a' <= c && c <= 'z') {
                sb.append((char)(c - 'a' + 'A'));
            } else {
                sb.append((char)(c - 'A' + 'a'));
            }
        }

        System.out.println(sb);
    }
}
