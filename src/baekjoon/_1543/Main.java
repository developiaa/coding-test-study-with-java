package baekjoon._1543;

import java.util.Scanner;

// 문서 검색
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.next();
        String word = sc.next();

        int wordLength = word.length();
        int count = 0;
        for (int i = 0; i < doc.length(); i++) {
            boolean isMatch = true;
            for (int j = 0; j < wordLength; j++) {
                if (i + j >= doc.length() || doc.charAt(i + j) != word.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                count++;
                i += wordLength - 1;
            }
        }

        System.out.println("count = " + count);

    }
}
