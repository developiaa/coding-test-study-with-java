package baekjoon.구간합._17232;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        int K = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[][] arr = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String next = sc.next();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = next.charAt(j - 1);
            }
        }

        while (T-- > 0) {
            int[][] acc = getPrefixSum(arr);

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(acc, i, j, K);
                    if (arr[i][j] == '*') {
                        nearAlive--;
                        if (nearAlive < a || nearAlive > b) {
                            arr[i][j] = '.';
                        }
                    } else if (a < nearAlive && nearAlive <= b) {
                        arr[i][j] = '*';
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


    }

    public static int[][] getPrefixSum(char[][] map) {
        int[][] acc = new int[map.length][map[0].length];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1]
                        + (map[i][j] == '*' ? 1 : 0);
            }
        }
        return acc;
    }

    public static int getRangeSum(int[][] arr, int i, int j, int k) {
        int r1 = Math.max(i - k, 1);
        int c1 = Math.max(j - k, 1);
        int r2 = Math.min(i + k, arr.length - 1);
        int c2 = Math.min(j + k, arr[0].length - 1);

        return arr[r2][c2] - arr[r1 - 1][c2] - arr[r2][c1 - 1] + arr[r1 - 1][c1 - 1];
    }


}
