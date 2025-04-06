package baekjoon.String._1919;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        int[] firstInt = getAlphabet(first);
        int[] secondInt = getAlphabet(second);

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(firstInt[i] - secondInt[i]);
        }

        System.out.println(answer);

    }

    public static int[] getAlphabet(String string) {
        int[] answer = new int[26];
        for (int i = 0; i < string.length(); i++) {
            answer[string.charAt(i) - 'a']++;
        }
        return answer;

    }

}
