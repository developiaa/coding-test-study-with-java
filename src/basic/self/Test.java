package basic.self;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        String formattedNumber = formatter.format(Long.valueOf(number));
        System.out.println(formattedNumber);
    }
}
