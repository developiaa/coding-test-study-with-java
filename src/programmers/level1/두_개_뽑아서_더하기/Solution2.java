package programmers.level1.두_개_뽑아서_더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
//        int[] numbers = {2, 1, 3, 4, 1}; // {2,3,4,5,6,7}
        int[] numbers = {5,0,2,7}; // {2,5,7,9,12}

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
