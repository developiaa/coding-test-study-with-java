package baekjoon._10250;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int distance = 1;
            int floor = 1;

            while (--N > 0) {
                floor++;
                if (floor > H) {
                    floor = 1;
                    distance++;
                }
            }

            System.out.printf("%d%02d\n", floor, distance);
        }
    }
}
