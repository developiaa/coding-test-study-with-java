package baekjoon._11005;

import java.util.Scanner;

// 틀림
public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);

        String s = "";

        while (N>0) {
            s = convert(N % B) + s;
            N = N / B;
        }
        System.out.println(s);
    }

    public static String convert(int s) {
        if (s >= 10) {
            char c = (char) (s - 10 + 'A');
            return String.valueOf(c);
        } else {
            return String.valueOf(s);
        }
    }
}
