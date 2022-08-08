package programmers.level1.제일_작은_수_제거하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2};
        // {4,3,2}
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return new int[]{-1};
        }
        int minIndex = 0;
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
            list.add(arr[i]);
        }
        list.remove(minIndex);

        int[] answer = new int[arr.length - 1];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
