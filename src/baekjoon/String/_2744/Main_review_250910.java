package baekjoon.String._2744;

import java.util.Scanner;

public class Main_review_250910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        char[] answer = new char[next.length()];
        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);
            if ('A' <= c && c <= 'Z') {
                answer[i] = (char)(c - 'A' + 'a');
            } else {
                answer[i] = (char)(c - 'a' + 'A');
            }
        }
        System.out.println(answer);
    }
}
