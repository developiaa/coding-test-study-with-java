package baekjoon.String._1543;

import java.util.Scanner;

public class Main_review_250405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String word = sc.nextLine();
        int length = str.length();
        String s = str.replaceAll(word, "");
        System.out.println((length - s.length()) / word.length());
    }
}
