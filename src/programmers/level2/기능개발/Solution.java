package programmers.level2.기능개발;

import java.util.*;

@Deprecated(since = "몇개의 테스트 케이스만 맞음")
public class Solution {
    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5}; // {2,1}

        int[] progresses = {90, 98, 97, 96, 98};
        int[] speeds = {1, 1, 1, 1, 1};// {5} 이전의 값만 비교하기 때문에 안됨

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1}; // {1,3,2}
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
            queue2.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        List<Integer> list = new ArrayList<>();

        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            Integer poll2 = 0;
            if (index != 0) {
                poll2 = queue2.poll();
            }

            if (!list.isEmpty() && poll2 >= poll) {
                Integer i1 = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                list.add(i1 + 1);
            } else {
                list.add(1);
                index++;
            }
        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }


}
