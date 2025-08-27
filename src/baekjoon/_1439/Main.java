package baekjoon._1439;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();

        int zeroCount = 0;
        int oneCount = 0;
        if (next.charAt(0) == '0') {
            oneCount++;
        } else {
            zeroCount++;
        }
        for (int i = 1; i < next.length(); i++) {
            if (next.charAt(i) != next.charAt(i - 1)) {
                if (next.charAt(i) == '0') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
        }

        System.out.println(Math.min(oneCount, zeroCount));
    }
}
