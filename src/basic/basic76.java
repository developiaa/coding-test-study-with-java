package basic;

import java.util.Scanner;

public class basic76 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        int num = DFS(number);
        System.out.println(num);

    }

    public static int DFS(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * DFS(number - 1);
        }
    }
}
