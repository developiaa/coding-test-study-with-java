package baekjoon.String._1543;

import java.util.Scanner;

// 문서 검색
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        String replace = doc.replace(word, "");
        System.out.println((doc.length() - replace.length()) / word.length());
    }
}
