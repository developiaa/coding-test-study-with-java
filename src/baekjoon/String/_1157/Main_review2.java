package baekjoon.String._1157;

import java.util.Scanner;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] alphabetCount = getAlphabetCount(str.toUpperCase());

        int maxCount = -1;
        char answer = 0;
        for (int i = 0; i < 26; i++) {
            if (maxCount < alphabetCount[i]) {
                maxCount = alphabetCount[i];
                answer = (char) (i + 'A');
            } else if (maxCount == alphabetCount[i]) {
                answer = '?';
            }
        }
        System.out.println(answer);

    }

    public static int[] getAlphabetCount(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'A']++;
        }
        return counts;
    }
}
