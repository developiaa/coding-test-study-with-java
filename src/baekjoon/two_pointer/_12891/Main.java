package baekjoon.two_pointer._12891;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        char[] sequence = sc.next().toCharArray();

        int[] minimumCount = new int[4];
        for (int i = 0; i < 4; i++) {
            minimumCount[i] = sc.nextInt();
        }

        int[] count = new int[4];
        for (int i = 0; i < P - 1; i++) {
            count[baseToIndex(sequence[i])]++;
        }

        int ans = 0;
        // 모든 경우의 수 탐색
        for (int i = P - 1; i < S; i++) {
            // 이번 윈도우의 끝 값을 추가
            count[baseToIndex(sequence[i])]++;
            if (isValid(count, minimumCount)) {
                ans++;
            }
            // 이번 윈도우의 첫 값을 제거
            count[baseToIndex(sequence[i - P + 1])]++;
        }

        System.out.println(ans);
    }

    static boolean isValid(int[] count, int[] minimumCount) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] < minimumCount[i]) {
                return false;
            }
        }
        return true;
    }

    static int baseToIndex(char alp) {
        if (alp == 'A') return 0;
        else if (alp == 'C') return 1;
        else if (alp == 'G') return 2;
        else if (alp == 'T') return 3;
        return -1;
    }

}
