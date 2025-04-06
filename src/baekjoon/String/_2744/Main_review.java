package baekjoon.String._2744;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] chars = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if ('A' <= c && c <= 'Z') {
                // 대문자 -> 소문자
                chars[i] = (char) (c - 'A' + 'a');
            } else if ('a' <= c && c <= 'z') {
                // 소문자 -> 대문자
                chars[i] = (char) (c - 'a' + 'A');
            }
        }
        System.out.println(chars);
    }
}
