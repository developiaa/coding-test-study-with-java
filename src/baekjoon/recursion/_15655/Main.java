package baekjoon.recursion._15655;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] output;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];
        output = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        perm(0, 0);
    }

    public static void perm(int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(output[i] + " ");
            }
            System.out.println(sb);

            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
