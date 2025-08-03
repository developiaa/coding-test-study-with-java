package baekjoon.queue._1158;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] ans = new int[N];
        boolean[] removed = new boolean[N];
        int currentIndex = -1;

        for (int i = 0; i < N; i++) {
            int count = 0;
            while (count < K) {
                currentIndex = (currentIndex + 1) % N;
                if(!removed[currentIndex]) count++;
            }
            removed[currentIndex] = true;
            ans[i] = currentIndex + 1;
        }

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i]);
            if (i != N - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
