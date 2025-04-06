package baekjoon.String._13223;

import java.util.Scanner;

public class Main_review_250405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 34 44 10
        String firstTime = sc.nextLine();
        String secondTime = sc.nextLine();

        String[] first = firstTime.split(":");
        String[] second = secondTime.split(":");

        /**
         * 이렇게 하면 안됨
         * 반례
         * 20:00:01
         * 20:00:00
         *
         * 00:00:-1 출력됨. 첫째 자리에서 음수가 나온다는 가정만 했기 때문 -> 초로 변환하여 처리하여야 함
         */
//        if (Integer.parseInt(first[0]) > Integer.parseInt(second[0])) {
//            second[0] = String.valueOf(Integer.parseInt(second[0]) + 24);
//        }

        int firstSeconds = Integer.parseInt(first[0]) * 60 * 60 + Integer.parseInt(first[1]) * 60 + Integer.parseInt(first[2]);
        int secondSeconds = Integer.parseInt(second[0]) * 60 * 60 + Integer.parseInt(second[1]) * 60 + Integer.parseInt(second[2]);

        int diff = secondSeconds - firstSeconds;
        if (diff <= 0) {
            diff += 24 * 3600;
        }

        int hour = diff / 60 / 60;
        int minute = (diff - (hour * 60 * 60)) / 60;
        int seconds = diff % 60;
        System.out.printf("%02d:%02d:%02d", hour, minute, seconds);
    }
}
