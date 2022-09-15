package programmers.level1.실패율;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};  // {3,4,2,1,5}

//        int N = 4;
//        int[] stages = {4, 4, 4, 4, 4}; // {4,1,2,3}

//        int N = 4;
//        int[] stages = {4};

        System.out.println(Arrays.toString(solution(N, stages)));
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        int[] failCount = new int[N + 2];
        int[] totalCount = new int[N + 1];

        for (int stage : stages) {
            failCount[stage]++;
        }

        totalCount[N] = failCount[N] + failCount[N + 1];
        for (int i = N - 1; i >= 1; i--) {
            totalCount[i] = failCount[i] + totalCount[i + 1];
        }

        for (int i = 1; i < totalCount.length; i++) {
            if (failCount[i] == 0 || totalCount[i] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) failCount[i] / totalCount[i]);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
