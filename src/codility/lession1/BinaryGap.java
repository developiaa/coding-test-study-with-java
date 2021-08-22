package codility.lession1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryGap {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        System.out.println(solution(number));
    }

    static int solution(int number) {
        // 2진수 변환
        String changeNumber = Integer.toBinaryString(number);
        String[] strArray = changeNumber.split("");

        int max = 0;
        int temp = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals("1")) {
                if (temp != 0) {
                    max = max < temp ? temp : max;
                }
                temp = 0;
            } else {
                temp++;
            }
        }

        return max;
    }
}
