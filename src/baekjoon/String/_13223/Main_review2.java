package baekjoon.String._13223;

import java.util.Scanner;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String next2 = sc.next();

        String[] split = next.split(":");
        String[] split2 = next2.split(":");

        int hour1 = Integer.parseInt(split[0]) * 60 * 60;
        int minute1 = Integer.parseInt(split[1]) * 60;
        int second1 = Integer.parseInt(split[2]);

        int total1 = hour1 + minute1 + second1;


        int hour2 = Integer.parseInt(split2[0]) * 60 * 60;
        int minute2 = Integer.parseInt(split2[1]) * 60;
        int second2 = Integer.parseInt(split2[2]);

        int total2 = hour2 + minute2 + second2;

        int diff = total2 - total1;
        if (diff <= 0) {
            diff += 24 * 60 * 60;
        }

        int diffHour = diff / 3600;
        int diffMinute = diff % 3600 / 60;
        int diffSecond = diff % 60;
        System.out.printf("%02d:%02d:%02d", diffHour, diffMinute, diffSecond);
    }
}
