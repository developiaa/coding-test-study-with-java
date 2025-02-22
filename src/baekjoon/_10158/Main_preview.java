package baekjoon._10158;

import java.util.Scanner;

// 시간 초과
public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int width = Integer.parseInt(data[0]);
        int height = Integer.parseInt(data[1]);

        String[] startingPoint = sc.nextLine().split(" ");
        int x = Integer.parseInt(startingPoint[0]);
        int y = Integer.parseInt(startingPoint[1]);

        int t = Integer.parseInt(sc.nextLine());
        int dx = 1;
        int dy = 1;
        while (t > 0) {
            if (x + dx < 0) {
                dx = -dx;
            }
            if (y + dy < 0) {
                dy = -dy;
            }

            if (x + dx > width) {
                dx = -dx;
            }
            if (y + dy > height) {
                dy = -dy;
            }
            x += dx;
            y += dy;
            t--;

        }
        System.out.println(x + " " + y);
    }
}
