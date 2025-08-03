package baekjoon.two_pointer._16472;

import java.util.Scanner;

public class Main2 {
    static int[] alphabetFrequency = new int[26];
    static int alphabetCount = 0;

    static void increaseFrequency(char ch) {
        if (alphabetFrequency[ch - 'a']++ == 0) {
            alphabetCount++;
        }
    }

    static void decreaseFrequency(char ch) {
        if (--alphabetFrequency[ch - 'a'] == 0) {
            alphabetCount--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] ch = sc.next().toCharArray();

        int nextIndex = 0;
        int answer = 0;
        for (int i = 0; i < ch.length; i++) {
            while (nextIndex < ch.length) {
                increaseFrequency(ch[nextIndex++]);
                if (alphabetCount > N) {
                    decreaseFrequency(ch[--nextIndex]);
                    break;
                }
            }
            answer = Math.max(answer, nextIndex - i);
            decreaseFrequency(ch[i]);
        }
        System.out.println(answer);
    }
}
