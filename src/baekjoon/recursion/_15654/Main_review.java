package baekjoon.recursion._15654;

import java.util.Arrays;
import java.util.Scanner;

public class Main_review {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] checked;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        checked = new boolean[N];
        answer = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        perm(0);
    }

    public static void perm(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                answer[depth] = arr[i];
                perm(depth + 1);
                checked[i] = false;
            }
        }
    }
}
