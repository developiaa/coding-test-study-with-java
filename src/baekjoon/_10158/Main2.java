package baekjoon._10158;

import java.util.Scanner;

// java11로 하면 시간 초과
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int T = sc.nextInt();

        int currentX = (T + P) % (2 * W);
        int currentY = (T + Q) % (2 * H);
        if (currentX > W) currentX = 2 * W - currentX;
        if (currentY > H) currentY = 2 * H - currentY;


        System.out.println(currentX + " " + currentY);
    }
}
