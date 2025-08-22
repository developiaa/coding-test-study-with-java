package baekjoon.two_pointer._1806;

import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();


        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int index = 0;
        int answer = N + 1;
        for (int i = 0; i < N; i++) {
            while (sum < S && index < N) {
                sum += arr[index];
                index++;
            }

            if (sum >= S) {
                answer = Math.min(answer, index - i);
            }
            sum -= arr[i];
        }

        if (answer > N) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
