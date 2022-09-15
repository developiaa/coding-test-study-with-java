package programmers.level1.실패율;

import java.util.*;

public class Solution3 {
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
        // 1 ~ N+1 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
        int[] currentUser = new int[N + 2];

        for (int stage : stages) {
            currentUser[stage]++;
        }

        // 1 ~ N까지 스테이지에 도달한 플레이어 수
        int[] totalUser = new int[N + 1];

        int temp = stages.length;
        for (int i = 1; i < N + 1; i++) {
            if (i == 1) {
                totalUser[i] = temp;
                continue;
            }
            totalUser[i] = temp - currentUser[i - 1];
            temp = totalUser[i];
        }

        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i < totalUser.length; i++) {
            if (currentUser[i] == 0 || totalUser[i] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) currentUser[i] / totalUser[i]);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());


        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
