package baekjoon._1302;

import java.util.*;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<String, Integer> map = new TreeMap<>();
        int max = 0;
        for(int i = 1; i <= N; i++) {
            String next = sc.next();
            if (map.containsKey(next)) {
                map.put(next, map.get(next) + 1);
            } else {
                map.put(next, 1);
            }

            max = Math.max(max, map.get(next));
        }
        for (String s : map.keySet()) {
            if(map.get(s) == max) {
                System.out.println(s);
                break;
            }
        }
    }
}
