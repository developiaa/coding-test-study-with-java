package baekjoon.divideconquer._1629;

import java.util.Scanner;

public class Main {
    static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(power(a, b));
    }

    static long power(int a, int b) {
        if (b == 1) return a % c;
        long half = power(a, b / 2);
        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return (((half * half) % c) * a) % c;
        }
    }
}
