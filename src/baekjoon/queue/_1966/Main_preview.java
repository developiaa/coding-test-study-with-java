package baekjoon.queue._1966;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<Node> queue = new LinkedList<>();
            Node[] arr = new Node[N];
            for (int i = 0; i < N; i++) {
                Node node = new Node(i, sc.nextInt());
                queue.offer(node);
                arr[i] = node;
            }

            Arrays.sort(arr, (o1, o2) -> o2.priority - o1.priority);

            int index = 0;
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                if (poll.priority == arr[index].priority) {
                    if (M == poll.index) {
                        System.out.println(index + 1);
                    }
                    index++;
                } else {
                    queue.offer(poll);
                }

            }
        }
    }

    static class Node {
        int index;
        int priority;

        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}

