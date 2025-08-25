package baekjoon.array._3273;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_review2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            set.add(num);
        }


        int x = sc.nextInt();

        int count = 0;
        for (Integer i : set) {
            if (set.contains(x - i)) {
                count++;
            }
        }

        System.out.println(count / 2);
    }
}
