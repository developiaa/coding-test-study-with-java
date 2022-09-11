package programmers.level1.나누어_떨어지는_숫자_배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {5, 9, 7, 10};
//        int divisor = 5; //{5,10}
//        int[] arr = {2, 36, 1, 3};
//        int divisor = 1; //{1,2,3,36}
        int[] arr = {3,2,6};
        int divisor = 10; //{-1}

        System.out.println(Arrays.toString(solution(arr, divisor)));
    }

    public static int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        if (list.size() == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
