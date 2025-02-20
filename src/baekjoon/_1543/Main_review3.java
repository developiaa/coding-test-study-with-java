package baekjoon._1543;

import java.util.Scanner;

public class Main_review3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        String replace = doc.replace(word, "");

        System.out.println((doc.length() - replace.length()) / word.length());
    }
}
