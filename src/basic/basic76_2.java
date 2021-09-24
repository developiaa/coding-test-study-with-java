package basic;

import java.util.Scanner;

public class basic76_2 {
    public static int[][] arr = new int[21][21];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int r = s.nextInt();

        int num = DFS(n, r);
        System.out.println(num);
    }

    public static int DFS(int n, int r) {
        if (arr[n][r] > 0) return arr[n][r];
        if (n == r || r == 0) return 1;
        else return arr[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);

    }
}
