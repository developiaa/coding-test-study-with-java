package programmers.level1.실패율;

import java.util.*;

@Deprecated(since = "실패")
public class Solution2 {
    public static void main(String[] args) {
//        int N = 5;
//        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};  // {3,4,2,1,5}

        int N = 4;
        int[] stages = {4, 4, 4, 4, 4}; // {4,1,2,3}

//        int N = 4;
//        int[] stages = {4};

        System.out.println(Arrays.toString(solution(N, stages)));
    }

    public static int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        Map<Integer, Float> map = new HashMap<>();

        float m = stages.length;
        // 1 2 2 2 3 3 4 6
        // 4 4 4 4 4
        // 0 0 0 5
        for (int i = 1; i <= N; i++) {
            float temp = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    temp++;
                    if (j == stages.length - 1) {
                        map.put(i, temp / m);
                        m = m - temp;
                    }
                } else if (stages[j] > i) {
                    if (temp == 0) {
                        map.put(i, 0f);
                    } else {
                        map.put(i, temp / m);
                    }
                    m = m - temp;
                    break;
                }
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(((o1, o2) -> Float.compare(map.get(o2), map.get(o1))));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
