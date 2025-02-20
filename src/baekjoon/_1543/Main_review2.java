package baekjoon._1543;

import java.util.Scanner;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.next();
        String word = sc.next();

        int startIndex = 0;

        int count = 0;
        while (true) {
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0) {
                break;
            }

            startIndex = findIndex + word.length();
            count++;
        }

        System.out.println(count);
    }
}
