package programmers.level1.신고결과받기;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 2;
        int k = 3;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Map<String, List<String>> returnMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], 0);
            returnMap.put(id_list[i], new ArrayList<>());
            list.add(id_list[i]);
        }

        // map = {"muzi":0, "frodo":0, "apeach":0, "neo":0}

        for (int i = 0; i < report.length; i++) {
            String[] data = report[i].split(" ");

            List<String> strings = returnMap.get(data[0]);
            if (!strings.contains(data[1])) {
                strings.add(data[1]);
                map.put(data[1], map.get(data[1]) + 1);
            }
        }


        for (String s : map.keySet()) {
            System.out.println(s + " : " + map.get(s));
        }

        System.out.println();
        for (String s : returnMap.keySet()) {
            System.out.println(s + " : " + returnMap.get(s));
        }

        Iterator<String> iterator = map.keySet().iterator();
        List<String> abc = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (map.get(key) >= k) {
                abc.add(key);
            }
        }

        System.out.println(abc);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            List<String> dd = returnMap.get(list.get(i));
            for (String s : dd) {
                if (abc.contains(s)) {
                    answer[i] = answer[i] + 1;
                }
            }
        }
        return answer;
    }
}
