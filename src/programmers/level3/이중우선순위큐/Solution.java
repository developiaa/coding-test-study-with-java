package programmers.level3.이중우선순위큐;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; // {0,0}
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; // {333, -45}

        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations) {
        DoublyPriorityQueue dpq = new DoublyPriorityQueue();
        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            String value = tokens[1];

            switch(command) {
                case "I"-> dpq.add(Integer.parseInt(value));
                case "D" -> {
                    if (value.equals("1")) {
                        dpq.removeMax();
                    }else {
                        dpq.removeMin();
                    }
                }
            }
        }

        return new int[]{dpq.max(), dpq.min()};
    }

    private static class DoublyPriorityQueue {
        private int size = 0;
        private final PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

        public void add(int value) {
            minPQ.add(value);
            maxPQ.add(value);
            size++;
        }

        public void removeMax() {
            if (size == 0) return;
            maxPQ.poll();
            if (--size == 0) {
                maxPQ.clear();
                minPQ.clear();
            }
        }

        public void removeMin() {
            if (size == 0) return;
            minPQ.poll();
            if (--size == 0) {
                maxPQ.clear();
                minPQ.clear();
            }
        }

        public int max() {
            if (size == 0) return 0;
            return maxPQ.peek();
        }

        public int min() {
            if (size == 0) return 0;
            return minPQ.peek();
        }
    }


}
