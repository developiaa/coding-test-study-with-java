package baekjoon.two_pointer._16472;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] ch = sc.next().toCharArray();
        int[] alphabet = new int[26];

        int nextIndex = 0;
        int answer = 0;
        for (int i = 0; i < ch.length; i++) {
            while (nextIndex < ch.length) {
                alphabet[ch[nextIndex] - 'a']++;
                if (getAlphabetCount(alphabet) > N) {
                    alphabet[ch[nextIndex] - 'a']--;
                    break;
                }
                nextIndex++;
            }
            answer = Math.max(answer, nextIndex - i);
            alphabet[ch[i] - 'a']--;
        }
        System.out.println(answer);
    }

    public static int getAlphabetCount(int[] alphabet) {
        int uniqueCount = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 0) {
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
}
