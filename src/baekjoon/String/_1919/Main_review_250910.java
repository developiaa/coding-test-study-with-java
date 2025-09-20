package baekjoon.String._1919;

import java.util.Scanner;

public class Main_review_250910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        char[] firstChar = extractedStringToCharArray(first);
        char[] secondChar = extractedStringToCharArray(second);

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(firstChar[i] - secondChar[i]);
        }
        System.out.println(count);
    }

    private static char[] extractedStringToCharArray(String first) {
        char[] firstChar = new char[26];
        for (int i = 0; i < first.length(); i++) {
            firstChar[first.charAt(i) - 'a']++;
        }
        return firstChar;
    }
}
