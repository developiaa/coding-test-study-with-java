package programmers.level1.없는숫자더하기;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
//        int[] number = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] number = {5, 8, 4, 0, 6, 7, 9};
        System.out.println(solution(number));
    }

    public static int solution(int[] number) {
        Set<Integer> set = new HashSet<>();
        for (int i : number) {
            set.add(i);
        }

        int sum = 0;
        for (int n = 0; n <= 9; n++) {
            if(set.contains(n)) continue;
            sum += n;
        }

        return sum;
    }
}
