package baekjoon._1543;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.next();
        String word = sc.next();

        int count = 0;
        for (int i = 0; i < doc.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                if (i + j >= doc.length() || doc.charAt(i + j) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
                i += word.length() - 1;
            }
        }

        System.out.println(count);
    }
}
