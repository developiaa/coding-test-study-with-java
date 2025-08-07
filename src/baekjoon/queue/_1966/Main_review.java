package baekjoon.queue._1966;

import java.io.IOException;
import java.util.*;

public class Main_review {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<Document> queue = new LinkedList<>();
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                int givenPriority = sc.nextInt();
                queue.offer(new Document(i, givenPriority));
                arr[i] = givenPriority;
            }

            Arrays.sort(arr, Collections.reverseOrder());

            int index = 0;
            while (!queue.isEmpty()) {
                Document poll = queue.poll();
                if (poll.priority == arr[index]) {
                    if (poll.index == M) {
                        System.out.println(index + 1);
                        break;
                    }
                    index++;
                } else {
                    queue.offer(poll);
                }
            }
        }
    }

    static class Document {
        final int index;
        final int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
