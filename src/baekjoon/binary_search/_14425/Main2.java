package baekjoon.binary_search._14425;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = sc.next();
        }

        Arrays.sort(str);

        int count = 0;
        while (M-- > 0) {
            String x = sc.next();
            if (Arrays.binarySearch(str, x) >= 0) {
                count++;
            }
        }
        System.out.println(count);
    }

}
