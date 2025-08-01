package baekjoon.two_pointer._15831;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();
        char[] arr = sc.next().toCharArray();


        int countBlack = 0;
        int countWhite = 0;
        int nextIndex = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N) {
                if (arr[nextIndex] == 'B' && countBlack == B) break;
                if (arr[nextIndex++] == 'W') countWhite++;
                else countBlack++;
            }
            if (countWhite >= W) {
                answer = Math.max(answer, nextIndex - i);
            }

            if (arr[i] == 'W') countWhite--;
            else countBlack--;
        }
        System.out.println(answer);
    }
}
