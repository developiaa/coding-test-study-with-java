package codility.lesson5;

import java.util.ArrayList;
import java.util.List;

//n2이라 퍼포먼스 안나옴
//60%
public class PassingCars {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 1}; // 5
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int count = 0;
        List<Integer> west = new ArrayList<>();
        List<Integer> east = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                west.add(i);
            } else {
                east.add(i);
            }
        }

        for (int i = 0; i < west.size(); i++) {
            for (int j = 0; j < east.size(); j++) {
                if (west.get(i) < east.get(j)) {
                    count++;
                }
            }
        }

        return count;

    }
}
