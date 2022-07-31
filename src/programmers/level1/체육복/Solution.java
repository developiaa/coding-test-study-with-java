package programmers.level1.체육복;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {2,3};
        // 5

//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reserve = {3};
        // 4
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int i : lost) {
            lostSet.add(i);
        }

        for (int i : reserve) {
            if (lostSet.contains(i)) {
                lostSet.remove(i);
                continue;
            }
            reserveSet.add(i);
        }



        for (Integer integer : reserveSet) {
            int minus = integer - 1;
            int plus = integer + 1;
            if (lostSet.contains(minus)) {
                lostSet.remove(minus);
            } else if (lostSet.contains(plus)) {
                lostSet.remove(plus);
            }
        }

        return n - lostSet.size();
    }
}
