package baekjoon.recursion._15656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];
        output = new int[M];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        perm(0);
        System.out.println(sb);

    }

    public static void perm(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            output[depth] = numbers[i];
            perm(depth + 1);
        }
    }
}
