package baekjoon._10814;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
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
            if (o1.age != o2.age) {
                return o1.age - o2.age;
            }
            return o1.index - o2.index;
        });

        for (Member member : arr) {
            System.out.println(member.age + " " + member.name);
        }

    }

    static class Member {
        private final String name;
        private final int age;
        private final int index;

        public Member(String name, int age, int index) {
            this.name = name;
            this.age = age;
            this.index = index;
        }
    }
}
