package baekjoon._1302;

import java.util.Arrays;
import java.util.Scanner;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] titles = new String[n];
        for (int i = 0; i < n; i++) {
            titles[i] = sc.next();
        }

        Arrays.sort(titles);

        String maxTitle = titles[0];
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < titles.length; i++) {
            if (!titles[i].equals(titles[i - 1])) {
                count = 0;
            }
            count++;
            if (maxCount < count || (maxCount == count && maxTitle.compareTo(titles[i]) > 0)) {
                maxTitle = titles[i];
                maxCount = count;
            }
        }

        System.out.println(maxTitle);
    }
}
