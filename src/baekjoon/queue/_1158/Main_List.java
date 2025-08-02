package baekjoon.queue._1158;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int[] answer = new int[N];
        int currentIndex = 0;
        for (int i = 0; i < N; i++) {
            currentIndex = (currentIndex + K - 1) % list.size();
            answer[i] = list.remove(currentIndex);
        }
        print(answer);
        // print(N, answer);
    }

    public static void print(int N, int[] answer) {
        System.out.print("<");
        for (int i = 0; i < N; i++) {
            System.out.print(answer[i]);
            if (i != N - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }

    public static void print(int[] answer) {
        System.out.println(
            "<" + Arrays.stream(answer)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "))
            + ">");
    }
}
