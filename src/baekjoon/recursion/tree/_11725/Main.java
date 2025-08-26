package baekjoon.recursion.tree._11725;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer>[] tree;
    static int[] parents;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n + 1];
        parents = new int[n + 1];
        check = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        find(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void find(int nodeNum) {
        check[nodeNum] = true;
        for (int i = 0; i < tree[nodeNum].size(); i++) {
            int child = tree[nodeNum].get(i);
            if (!check[child]) {
                parents[child] = nodeNum;
                find(child);
            }
        }
    }
}
