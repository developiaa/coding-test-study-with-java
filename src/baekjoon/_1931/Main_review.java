package baekjoon._1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Course[] arr = new Course[N];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = new Course(a, b);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int count = 0;
        int ended = 0;
        for (int i = 0; i < N; i++) {
            if (ended <= arr[i].start) {
                count++;
                ended = arr[i].end;
            }
        }

        System.out.println(count);

    }

    static class Course {
        int start;
        int end;

        public Course(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
