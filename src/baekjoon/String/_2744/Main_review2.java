package baekjoon.String._2744;

import java.util.Scanner;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);
            if ('A' <= c && c <= 'Z') {
                sb.append((char)(c - 'A' + 'a'));
            } else {
                sb.append((char)(c - 'a' + 'A'));
            }
        }
        System.out.println(sb.toString());
    }


}
