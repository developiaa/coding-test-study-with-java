package programmers.practice.lotto;

import java.util.*;

public class lotto {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // 등수 셋팅
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,6);
        for (int i=0; i<7; i++){
            if(i==0){
                map.put(0,6);
                continue;
            }
            map.put(i,7-i);
        }
        Set<Integer> set = new HashSet<>();
        for (int win_num : win_nums) {
            set.add(win_num);
        }

        for (int i = 0; i < lottos.length; i++) {
            set.remove(lottos[i]);
        }
        //0의 갯수 파악
        int index =0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                index++;
            }
        }

        System.out.println(index);
        System.out.println(set);

        //최소 맞은 갯수
        int minLength = lottos.length - set.size();
        //최대로 맞을수 있는 갯수
        int maxLength = index+minLength;


        answer[0]=map.get(maxLength);
        answer[1]=map.get(minLength);

        return answer;
    }
}
