package baekjoon.String._1919;

import java.util.Scanner;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();

        int[] alphabetCount = getAlphabetCount(input1);
        int[] alphabetCount2 = getAlphabetCount(input2);
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(alphabetCount[i] - alphabetCount2[i]);
        }
        System.out.println(count);
    }

    public static int[] getAlphabetCount(String input) {
        int[] alphabet = new int[26];
        for (int i = 0; i < input.length(); i++) {
            alphabet[input.charAt(i) - 'a']++;
        }
        return alphabet;
    }
}
