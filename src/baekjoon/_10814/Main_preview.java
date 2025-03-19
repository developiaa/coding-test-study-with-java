package baekjoon._10814;

import java.util.Arrays;
import java.util.Scanner;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Member[] arr = new Member[N];

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            arr[i] = new Member(name, age, i);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.compareTo(o2);
            }
            return o1.age - o2.age;
        });

        for (Member member : arr) {
            System.out.println(member);
        }

    }

    static class Member implements Comparable<Member> {
        private final String name;
        private final int age;
        private final int index;

        public Member(String name, int age, int index) {
            this.name = name;
            this.age = age;
            this.index = index;
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }

        @Override
        public int compareTo(Member o) {
            return this.index - o.index;
        }
    }
}
