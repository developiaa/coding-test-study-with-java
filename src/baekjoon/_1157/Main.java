package baekjoon._1157;

import java.util.Scanner;

// 단어 공부
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine().toUpperCase();
        int[] count = new int[26];
        for (int i = 0; i < next.length(); i++) {
            count[next.charAt(i) - 'A']++;
        }

        int maxCount = -1;
        char maxAlphabet = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlphabet = (char) ('A' + i);
            } else if (count[i] == maxCount) {
                maxAlphabet = '?';
            }
        }

        System.out.println(maxAlphabet);
    }
}
