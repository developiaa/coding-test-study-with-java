package codility.lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public static void main(String[] args) {
        int[]A = {2,1,1,2,3,1};
        System.out.println(solution(A));
    }

    public static int solution(int[]A){
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        return set.size();

    }
}
