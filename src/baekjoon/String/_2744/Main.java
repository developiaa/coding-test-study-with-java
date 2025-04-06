package baekjoon.String._2744;

import java.util.Scanner;

public class Main {
    // wRONGaNSWER
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                chars[i] = (char) ('a' + ch - 'A');
            } else {
                chars[i] = (char) ('A' + ch - 'a');
            }
        }
        System.out.println(chars);
    }
}
