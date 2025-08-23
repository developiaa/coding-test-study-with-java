package baekjoon.String._1919;

import java.util.Scanner;

public class Main_review_250810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] first = sc.next().toCharArray();
        char[] second = sc.next().toCharArray();

        int[] firstCount = getAlphabet(first);
        int[] secondCount = getAlphabet(second);

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(firstCount[i] - secondCount[i]);
        }
        System.out.println(count);
    }

    private static int[] getAlphabet(char[] first) {
        int[] firstCount = new int[26];
        for (char c : first) {
            firstCount[c - 'a']++;
        }
        return firstCount;
    }
}
