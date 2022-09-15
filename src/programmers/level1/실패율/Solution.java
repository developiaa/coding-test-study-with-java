package programmers.level1.실패율;

import java.util.*;

@Deprecated(since = "실패")
public class Solution {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};  // {3,4,2,1,5}

//        int N = 4;
//        int[] stages = {4, 4, 4, 4, 4}; // {4,1,2,3}
        System.out.println(Arrays.toString(solution(N, stages)));
    }

    public static int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        float[] ints = new float[N];
        Map<Integer, Float> map = new HashMap<>();
        List<Float> list = new ArrayList<>();
        float m = stages.length;
        // 1 2 2 2 3 3 4 6
        // 4 4 4 4 4
        for (int i = 1; i <= N+1; i++) {
            float temp = 0f;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    temp++;
                } else if (stages[j] > i) {
                    if (temp == 0) {
                        list.add(0f);
                        map.put(i, 0f);
                    } else {
                        list.add(temp / m);
                        map.put(i, temp / m);
                    }
                    m = m - temp;
                    break;
                }
            }
        }
        System.out.println(map);
        System.out.println("list = " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("list = " + list);

        for (Integer integer : map.keySet()) {
            ints[integer-1] = map.get(integer);
        }

        System.out.println(Arrays.toString(ints));

        return new int[]{};
    }
}
