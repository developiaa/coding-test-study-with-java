package baekjoon.String._1543;

import java.util.Scanner;

public class Main_review_250405_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String word = sc.nextLine();

        int startIndex = 0;
        int answer = 0;
        while (true) {
            int findIndex = str.indexOf(word, startIndex);
            if (findIndex == -1) {
                break;
            }

            startIndex = findIndex + word.length();
            answer++;
        }

        System.out.println(answer);
    }
}
