package programmers.test.NF;

import java.util.*;

//["0001 3 95","0001 5 90","0001 5 100","0002 3 95","0001 7 80","0001 8 80","0001 10 90","0002 10 90","0002 7 80","0002 8 80","0002 5 100","0003 99 90"]["0001","0002"]
//        ["1901 1 100","1901 2 100","1901 4 100","1901 7 100","1901 8 100","1902 2 100","1902 1 100","1902 7 100","1902 4 100","1902 8 100","1903 8 100","1903 7 100","1903 4 100","1903 2 100","1903 1 100","1101 1 95","1101 2 100","1101 4 100","1101 7 100","1101 9 100","1102 1 95","1102 2 100","1102 4 100","1102 7 100","1102 9 100"]["1101","1102","1901","1902","1903"]
//        ["1901 10 50","1909 10 50"]["None"]

public class test3 {
    public static void main(String[] args) {
        String[] A = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
        System.out.println(solution(A));
    }

    public static String[] solution(String[] logs) {
        String[] answer = {};
        Arrays.sort(logs, Comparator.naturalOrder());
        System.out.println(Arrays.toString(logs));

        Map<String, List<Map<String, String>>> map = new HashMap<>();
        List<Map<String, String>> temp = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String[] tempArr = logs[i].split(" ");
            System.out.println(Arrays.toString(tempArr));
            if (!map.containsKey(tempArr[0])) {
                temp = new ArrayList<> ();
            }

            if (!map.containsKey(tempArr[1])) {
                Map<String, String> tempMap = new HashMap<>();
                tempMap.put(tempArr[1], tempArr[2]);
                System.out.println("tempMap = " + tempMap);
                temp.add(tempMap);
            }
            map.put(tempArr[0], temp);
        }

        for (List<Map<String, String>> value : map.values()) {
            System.out.println("value = " + value);
        }


//        Set<Integer> set = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//
//        for (int i = 0; i < map.size(); i++) {
//            Map<String, String> t = map.get(i);
//            System.out.println(t);
//            if (!set.contains(t.size())) {
//                set.add(t.size());
//            } else {
//                // 중복된 문제가 있는 경우 key저장
//
//            }
//        }
//        System.out.println("set2 = " + set);
        return answer;
    }

}
