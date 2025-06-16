package baekjoon.String._1543;

import java.util.Scanner;

public class Main_review4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String input = sc.nextLine();
        String replaceStr = str.replace(input, "");

        System.out.println((str.length() - replaceStr.length()) / input.length());
    }
}
