package basic.nTest;

import java.util.HashSet;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        int[] A = {7, 7, 7};
        System.out.println(solution(A));
    }

    public static boolean solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (set.contains(i)) {
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        return set.isEmpty();
    }
}
