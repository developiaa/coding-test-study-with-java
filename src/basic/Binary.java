package basic;

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int value = s.nextInt();
        binary(value);
    }

    public static void binary(int value) {
        if (value == 0) {
            return;
        }

        int val = value / 2;
        int remain = value % 2;
        binary(val);
        System.out.print(remain + "");
    }
}
