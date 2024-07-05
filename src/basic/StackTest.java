package basic;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        QueueT q = new QueueT();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }

    static class QueueT{
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();

        public void push(int x) {
            firstStack.push(x);
        }

        public int pop() {
            if(firstStack.isEmpty()) {
                return -1;
            }
            while (firstStack.size() != 1) {
                secondStack.push(firstStack.pop());
            }
            int result = firstStack.pop();
            while(!secondStack.isEmpty()) {
                firstStack.push(secondStack.pop());
            }
            return result;
        }

    }
}
