package baekjoon.recursion._9663;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solve(n, 0));

    }

    static int[] queen = new int[15];

    public static int solve(int n, int row) {
        int count = 0;
        if (row == n) return 1;

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queen[row] = col;
                count += solve(n, row + 1);
            }
        }
        return count;

    }

    public static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col) return false;
            if (Math.abs(col - queen[i]) == Math.abs(row - i)) return false;
        }
        return true;
    }
}
