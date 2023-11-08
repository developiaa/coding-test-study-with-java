package programmers.level2.기능개발;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5}; // {2,1}

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1}; // {1,3,2}
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int expiration = (int) Math.ceil(
                    (double) (100 - progresses[index]) / speeds[index]);

            if (expiration > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;
        }
        result.add(count);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
