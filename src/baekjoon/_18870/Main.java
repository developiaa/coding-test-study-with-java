package baekjoon._18870;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1. 입력된 좌표를 작은 순으로 정렬한다.
        int[][] xs = new int[N][2]; // 0: x, 1: inputIndex
        for (int i = 0; i < N; i++) {
            xs[i][0] = sc.nextInt();
            xs[i][1] = i;
        }

        Arrays.sort(xs, (o1, o2) -> o1[0] - o2[0]);

        // 2. 정렬된 좌표를 중복을 제거하며 압축된 인덱스를 기록한다.
        int[] ans = new int[N];
        int idx = 0;
        ans[xs[0][1]] = idx;
        for (int i = 1; i < N; i++) {
            if (xs[i][0] != xs[i - 1][0]) {
                idx++;
            }
            ans[xs[i][1]] = idx;
        }

        // 3. 입력된 좌표에 알맞은 압축 인덱스를 출력한다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
