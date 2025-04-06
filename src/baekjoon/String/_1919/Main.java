package baekjoon.String._1919;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 8
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] countA = getAlphabetCount(a);
        int[] countB = getAlphabetCount(b);

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(countA[i] - countB[i]);
//            if (countA[i] > countB[i]) {
//                answer += countA[i] - countB[i];
//            } else if (countA[i] < countB[i]) {
//                answer += countB[i] - countA[i];
//            }
        }
        System.out.println(answer);
    }

    public static int[] getAlphabetCount(String string) {
        int[] count = new int[26];
        for (int i = 0; i < string.length(); i++) {
            count[string.charAt(i) - 'a']++;
        }
        return count;
    }
}
