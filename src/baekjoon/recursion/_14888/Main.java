package baekjoon.recursion._14888;

import java.util.Scanner;

public class Main {
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MUL = 2;
    public static final int DIV = 3;
    public static int n;
    public static int[] numbers;
    public static int[] operator = new int[4];

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        solve(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int index, int sum) {
        if (index == n) {
            if (sum > max) max = sum;
            if (sum < min) min = sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case PLUS -> solve(index + 1, sum + numbers[index]);
                    case MINUS -> solve(index + 1, sum - numbers[index]);
                    case MUL -> solve(index + 1, sum * numbers[index]);
                    case DIV -> solve(index + 1, sum / numbers[index]);
                }
                operator[i]++;
            }
        }
    }


}
