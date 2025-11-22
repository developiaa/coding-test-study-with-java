package baekjoon.String._1919;

import java.util.Scanner;

public class Main_review3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        char[] firstChar = first.toCharArray();
        char[] secondChar = second.toCharArray();

        char[] firstAlphabet = getChars(firstChar);
        char[] secondAlphabet = getChars(secondChar);

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(firstAlphabet[i] - secondAlphabet[i]);
        }

        System.out.println(count);
    }

    private static char[] getChars(char[] firstChar) {
        char[] firstAlphabet = new char[26];
        for (char c : firstChar) {
            firstAlphabet[(char) (c - 'a')]++;
        }
        return firstAlphabet;
    }
}
