package basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue 2개로 stack 만들기
 */
public class QueueTest {
    public static void main(String[] args) {
        StackQ stack = new StackQ();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    /**
     * enqueue, dequeue 2개의 큐 역할
     * 시간복잡도는 push는 O(1), pop 최악의 경우 O(N)
     */
    static class StackQ {
        Queue<Integer> mainQueue = new LinkedList<>();
        Queue<Integer> secondQueue = new LinkedList<>();

        public void push(int x) {
            mainQueue.offer(x);
        }

        public int pop() {
            if (mainQueue.isEmpty()) {
                return -1;
            }

            int result = -1;
            while (mainQueue.size() != 1) {
                secondQueue.offer(mainQueue.poll());
            }
            result = mainQueue.poll();

            while (!secondQueue.isEmpty()) {
                mainQueue.offer(secondQueue.poll());
            }

            return result;
        }
    }

}
