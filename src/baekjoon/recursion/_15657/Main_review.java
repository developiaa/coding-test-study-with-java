package baekjoon.recursion._15657;

import java.util.Arrays;
import java.util.Scanner;

// 12분
public class Main_review {
    static int n;
    static int m;
    static int[] arr;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        answer = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        perm(0, 0);
    }

    public static void perm(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }


        for (int i = start; i < n; i++) {
            answer[depth] = arr[i];
            perm(depth + 1, i);
        }

    }
}
