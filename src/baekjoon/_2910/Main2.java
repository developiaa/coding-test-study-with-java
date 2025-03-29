package baekjoon._2910;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            int message = sc.nextInt();
            map.put(message, map.getOrDefault(message, 0) + 1);
        }

        Integer[] frequencies = map.keySet().toArray(new Integer[0]);
        Arrays.sort(frequencies, (o1, o2) -> map.get(o2) - map.get(o1));

        // 1. 더 많이 등장한 숫자 먼저
        // 2. 등장 횟수가 같다면 입력으로 먼저 들어온 것이 먼저

        for (int frequency : frequencies) {
            int count = map.get(frequency);
            while (count-- > 0) {
                System.out.print(frequency + " ");
            }
        }
        System.out.println();
    }
}
