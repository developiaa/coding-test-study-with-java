package baekjoon.two_pointer._11728;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }
        int i = 0;
        int j = 0;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (i < N && j < M) {
            if (arr[i] < arr2[j]) {
                bw.write(arr[i] + " ");
                i++;
            } else {
                bw.write(arr2[j] + " ");
                j++;
            }
        }

        while (i < N) {
            bw.write(arr[i] + " ");
            i++;
        }

        while (j < M) {
            bw.write(arr2[j] + " ");
            j++;
        }
        bw.write("\n");
        bw.flush();
    }
}
