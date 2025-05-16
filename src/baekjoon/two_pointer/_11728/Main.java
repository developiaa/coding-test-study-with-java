package baekjoon.two_pointer._11728;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[M];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            b[i] = sc.nextInt();
        }
        int[] answer = new int[N + M];

        int indexA = 0;
        int indexB = 0;
        int indexAnswer = 0;
        while (indexA < N && indexB < M) {
            if (a[indexA] < b[indexB]) {
                answer[indexAnswer++] = a[indexA++];
            } else {
                answer[indexAnswer++] = b[indexB++];
            }
        }

        while (indexA < N) {
            answer[indexAnswer++] = a[indexA++];
        }
        while (indexB < M) {
            answer[indexAnswer++] = b[indexB++];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int x : answer) {
            bw.write(x + " ");
        }
        bw.write("\n");
        bw.flush();

    }
}
