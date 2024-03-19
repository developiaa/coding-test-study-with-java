package programmers.level3.길_찾기_게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
        int[][] nodeinfo = {{5, 3}, {11, 5},
                {13, 3}, {3, 5}, {6, 1},
                {1, 3}, {8, 6}, {7, 2}, {2, 2}};

        int[][] solution = solution(nodeinfo);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (a, b) -> b.y - a.y);
        Node root = constructTree(nodes);
        List<Integer> preorder = new ArrayList<>();
        pre(root, preorder);

        List<Integer> postorder = new ArrayList<>();
        post(root, postorder);

        return new int[][]{
                preorder.stream().mapToInt(Integer::intValue).toArray(),
                postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    private static void pre(Node node, List<Integer> visits) {
        if (node == null) {
            return;
        }

        visits.add(node.value);
        pre(node.left, visits);
        pre(node.right, visits);
    }

    private static void post(Node node, List<Integer> visits) {
        if (node == null) {
            return;
        }

        post(node.left, visits);
        post(node.right, visits);
        visits.add(node.value);
    }

    private static Node constructTree(Node[] nodes) {
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }
        return root;
    }

    private static void insert(Node root, Node node) {
        // x 좌표에 따라 root 노드가 나타내는 트리에 node 삽입
        if (node.x < root.x) {
            //왼쪽 트리에 삽입
            if (root.left == null) {
                root.left = node;
            } else {
                //재귀호출로 왼쪽 트리에서 다시 찾음
                insert(root.left, node);
            }
        } else {
            //오른쪽 트리에 삽입
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    private static class Node {
        public final int value;
        public final int x;
        public final int y;

        public Node left;
        public Node right;

        private Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
}
