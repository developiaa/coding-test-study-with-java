package baekjoon.String._1157;

import java.util.Scanner;

public class Main_review3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = sc.next().toCharArray();

        char[] alphabet = new char[26];

        for (char c : charArray) {
            if ('a' <= c && c <= 'z') {
                alphabet[c - 'a']++;
            } else {
                alphabet[c - 'A']++;
            }
        }

        int max = 0;
        char answer = '?';
        for (int i = 0; i < alphabet.length; i++) {
            if (max < alphabet[i]) {
                max = alphabet[i];
                answer = (char) (i + 'A');
            } else if (max == alphabet[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
