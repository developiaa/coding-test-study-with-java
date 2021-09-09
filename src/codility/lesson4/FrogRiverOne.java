package codility.lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public static void main(String[] args) {
        int X = 5;
        int []A = {1,3,1,4,2,3,5,4};
        System.out.println(solution(X, A));
    }

    public static int solution(int X, int[] A){
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=X; i++){
            set.add(i);
        }

        for (int i=0; i<A.length; i++){
            set.remove(A[i]);
            if(set.isEmpty()){
                return i;
            }
        }

        return -1;
    }
}
