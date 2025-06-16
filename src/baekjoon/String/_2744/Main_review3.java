package baekjoon.String._2744;

import java.util.Scanner;

public class Main_review3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        StringBuilder sb = new StringBuilder();
        char[] charArray = next.toCharArray();
        for (char c : charArray) {
            if (65 <= c && c <= 90) {
                sb.append(String.valueOf(c).toLowerCase());

            } else if (97 <= c && c <= 122) {
                sb.append(String.valueOf(c).toUpperCase());
            }
        }
        System.out.println(sb.toString());
    }


}
