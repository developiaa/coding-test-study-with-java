package baekjoon.String._1919;

import java.util.Scanner;

public class Main_review_250405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        int[] countA = getCount(a);
        int[] countB = getCount(b);

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(countA[i] - countB[i]);
        }

        System.out.println(answer);
    }

    public static int[] getCount(String a) {
        // 글자의 카운트를 가져온다
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
        }
        return count;
    }
}
