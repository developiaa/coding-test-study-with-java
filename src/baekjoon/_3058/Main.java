package baekjoon._3058;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int sum = 0;
            int min = 101;
            for (int i = 0; i <7; i++) {
                int value = sc.nextInt();

                if (value % 2 == 0) {
                    sum += value;

                    min = Math.min(min, value);
                }
            }
            System.out.println(sum + " " + min);
        }
    }
}
