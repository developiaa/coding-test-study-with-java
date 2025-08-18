package baekjoon.stack._17298;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[N];
        answer[N - 1] = -1;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                stack.push(arr[i + 1]);
                answer[i] = arr[i + 1];
            } else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    answer[i] = -1;
                } else {
                    answer[i] = stack.peek();
                }
            }
        }

        System.out.println(Arrays.stream(answer)
                .mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
