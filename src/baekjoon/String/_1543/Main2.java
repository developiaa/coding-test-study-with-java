package baekjoon.String._1543;

import java.util.Scanner;

// 문서 검색
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

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
