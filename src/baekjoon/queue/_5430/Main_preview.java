package baekjoon.queue._5430;

import java.util.*;

// 마지막 테스트 반례 틀림
public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            char[] ch = sc.next().toCharArray();
            int n = sc.nextInt();
            String next = sc.next();
            String substring = next.substring(1, next.length() - 1);
            if (substring.isEmpty()) {
                System.out.println("error");
                continue;
            }

            String[] split = substring.split(",");
            if (split.length == 1) {
                System.out.println("error");
                continue;
            }
            int[] array = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                int num = Integer.parseInt(split[i]);
                if (0 <= num && num <= 100) {
                    array[i] = Integer.parseInt(split[i]);

                }
            }

            Deque<Integer> queue = new LinkedList<>();
            for (int i : array) {
                queue.offer(i);
            }

            boolean flag = true; // 정방향인지
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 'R') {
                    flag = !flag;
                } else {
                    if (flag) {
                        queue.pollFirst();
                    } else {
                        queue.pollLast();
                    }
                }
            }

            boolean check = false;
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                if (flag) {
                    sb.append(queue.pollFirst());
                    if (!queue.isEmpty()) sb.append(",");
                } else {
                    sb.append(queue.pollLast());
                    if (!queue.isEmpty()) sb.append(",");
                }
                check = true;
            }
            System.out.println("[" + sb + "]");
            if (!check) {
                System.out.println("error");
            }

        }
    }
}
