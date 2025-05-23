package baekjoon._10814;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Member[] arr = new Member[N];

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            arr[i] = new Member(name, age);
        }

        Arrays.sort(arr);

        for (Member member : arr) {
            System.out.println(member.age + " " + member.name);
        }

    }

    static class Member implements Comparable<Member> {
        private final String name;
        private final int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Member o) {
            return this.age - o.age;
        }
    }
}
