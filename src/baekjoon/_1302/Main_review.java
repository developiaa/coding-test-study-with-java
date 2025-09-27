package baekjoon._1302;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> map = new TreeMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            list.add(next);
            map.put(next, map.getOrDefault(next, 0) + 1);
        }

        int max = 0;
        String answer = "";
        for (String s : map.keySet()) {
            if (max < map.get(s)) {
                max = map.get(s);
                answer = s;
            }
        }

        System.out.println(answer);
    }
}
