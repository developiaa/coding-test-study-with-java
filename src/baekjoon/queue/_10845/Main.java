package baekjoon.queue._10845;

import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
//        Queue<Integer> q = new LinkedList<>();
//        int lastValue = -1;
//        while (N-- > 0) {
//            String[] cmd = br.readLine().split(" ");
//            if (cmd[0].equals("push")) {
//                lastValue = Integer.parseInt(cmd[1]);
//                q.offer(lastValue);
//            } else if (cmd[0].equals("pop")) {
//                if (q.isEmpty()) {
//                    bw.write("-1\n");
//                } else {
//                    bw.write(q.poll() + "\n");
//                }
//            } else if (cmd[0].equals("size")) {
//                bw.write(q.size() + "\n");
//            } else if (cmd[0].equals("empty")) {
//                bw.write(q.isEmpty() ? "1\n" : "0\n");
//            } else if (cmd[0].equals("front")) {
//                bw.write(q.isEmpty() ? "-1\n" : q.peek() + "\n");
//            } else if (cmd[0].equals("back")) {
//                bw.write(q.isEmpty() ? "-1\n" : lastValue + "\n");
//            }
//        }

        MyQueue<Integer> q = new MyQueue<>();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push")) {
                q.enqueue(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("pop")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.dequeue() + "\n");
                }
            } else if (cmd[0].equals("size")) {
                bw.write(q.size() + "\n");
            } else if (cmd[0].equals("empty")) {
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            } else if (cmd[0].equals("front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.getFront() + "\n");
            } else if (cmd[0].equals("back")) {
                bw.write(q.isEmpty() ? "-1\n" : q.getRear() + "\n");
            }
        }

        bw.flush();
    }
}

class MyQueue<E> {
    private int size = 0;
    private Node<E> frontNode = null;
    private Node<E> rearNode = null;

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) frontNode = newNode;
        else rearNode.next = newNode;
        rearNode = newNode;
        size++;
    }

    public E dequeue() {
        if(size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        E item = frontNode.item;
        frontNode = frontNode.next;
        if (frontNode == null) {
            rearNode = null;
        }
        size--;
        return item;
    }

    public E getFront() {
        return frontNode.item;
    }

    public E getRear() {
        return rearNode.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
