package baekjoon.priorityqueue._1927;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinPriorityQueue pq = new MinPriorityQueue();
        int n = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                ans.append(pq.pop()).append("\n");
            } else {
                pq.push(x);
            }
        }
        System.out.println(ans);
    }
}

class MinPriorityQueue {
    int[] heap;
    int size;

    public MinPriorityQueue() {
        this.heap = new int[100001];
        this.size = 0;
    }

    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void push(int x) {
        heap[++size] = x;
        int current = size;

        while (current > 1) {
            int parent = current / 2;
            if (heap[parent] <= heap[current]) break;
            swap(parent, current);
            current = parent;
        }
    }

    public int pop() {
        if (size == 0) return 0;
        int ret = heap[1];
        heap[1] = heap[size--];
        int current = 1;
        while (current * 2 <= size) {
            int left = current * 2;
            int right = left + 1;
            int child = left;

            if (right <= size && heap[left] > heap[right]) {
                child = right;
            }
            if (heap[current] <= heap[child]) break;
            swap(current, child);
            current = child;
        }

        return ret;
    }
}
