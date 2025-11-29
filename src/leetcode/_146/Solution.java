package leetcode._146;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    static class LRUCache {
        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> cache;

        private final Node head;
        private final Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();

            // 더미 노드 초기화 및 연결
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }

            Node node = cache.get(key);
            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addNode(newNode);

                if (cache.size() > capacity) {
                    Node lru = popTail();
                    cache.remove(lru.key);
                }
            }
        }

        private void addNode(Node node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(Node node) {
            removeNode(node); // 현재 위치에서 떼어내고
            addNode(node);    // 맨 앞으로 이동
        }

        private Node popTail() {
            Node res = tail.prev;
            removeNode(res);
            return res;
        }
    }

}


