package baekjoon.String._1157;

import java.util.Scanner;

public class Main_review_250910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();

        char[] alphabetCount = getAlphabetCount(next);
        int max = 0;
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            if (max < alphabetCount[i]) {
                max = alphabetCount[i];
                answer = (char)(i + 'A');
            } else if (max == alphabetCount[i]) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }

    public static char[] getAlphabetCount(String str) {
        char[] chars = new char[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('A' <= c && c <= 'Z') {
                chars[c - 'A']++;
            } else {
                chars[c - 'a']++;
            }
        }
        return chars;
    }
}
