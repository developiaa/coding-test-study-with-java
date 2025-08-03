package baekjoon.two_pointer._16472;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] ch = sc.next().toCharArray();
        int[] alphabet = new int[26];

        int nextIndex = 0;
        int answer = 0;
        int alphabetCount = 0;
        for (int i = 0; i < ch.length; i++) {
            while (nextIndex < ch.length) {
                if (alphabet[ch[nextIndex++] - 'a']++ == 0) {
                    alphabetCount++;
                }
                if (alphabetCount > N) {
                    if (--alphabet[ch[--nextIndex] - 'a'] == 0) {
                        alphabetCount--;
                    }
                    break;
                }
            }
            answer = Math.max(answer, nextIndex - i);
            if (--alphabet[ch[i] - 'a'] == 0) {
                alphabetCount--;
            }
        }
        System.out.println(answer);
    }
}
