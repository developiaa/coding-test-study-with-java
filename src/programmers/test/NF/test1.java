package programmers.test.NF;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class test1 {
    public static void main(String[] args) {
        String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
//        String[] id_list = {"A B C D", "A D", "A B D", "B D"};
        int K = 3;
        System.out.println(solution(id_list, K));
    }

    public static int solution(String[] id_list, int K) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < id_list.length; i++) {
            String[] temp = id_list[i].split(" ");
            HashSet<String> hashSet = new HashSet<>(Arrays.asList(temp));
            String[] data = hashSet.toArray(new String[0]);

            for (int j = 0; j < data.length; j++) {
                if (!map.containsKey(data[j])) {
                    System.out.println("1" + data[j]);
                    map.put(data[j], 1);
                } else {
                    int num = map.get(data[j]);
                    System.out.println("2" + data[j]);
                    System.out.print(num);
                    System.out.println();
                    num++;
                    if (num >= K) {
                        num = K;
                    }
                    map.put(data[j], num);
                }
            }
        }

        for (Integer s : map.values()) {
            answer += s;
        }
        System.out.println("map = " + map);
        return answer;
    }
}
