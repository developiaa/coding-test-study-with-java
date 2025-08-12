package baekjoon.stack._10799;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();
        int openCount = 0;

        int answer = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                openCount++;
            } else {
                openCount--;
                if (input[i - 1] == '(') {
                    answer += openCount;
                } else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
