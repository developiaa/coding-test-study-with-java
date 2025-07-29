package baekjoon.binary_search._14425;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> set = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            set.add(s);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(sc.next())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
