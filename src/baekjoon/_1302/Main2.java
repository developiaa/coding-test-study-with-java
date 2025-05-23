package baekjoon._1302;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] titles = new String[N];
        for (int i = 0; i < N; i++) {
            titles[i] = sc.next();
        }

        Arrays.sort(titles);

        String maxTitle = titles[0];
        int maxCount = 0;
        int currentCount = 0;
        for (int i = 1; i < N; i++) {
            if (!titles[i - 1].equals(titles[i])) {
                currentCount = 0;
            }
            currentCount++;

            if (maxCount < currentCount ||
                    (maxCount == currentCount && titles[i].compareTo(maxTitle) < 0)) {
                maxCount = currentCount;
                maxTitle = titles[i];
            }
        }

        System.out.println(maxTitle);

    }
}
