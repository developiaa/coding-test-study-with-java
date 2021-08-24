package codility;

import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        //int[] A = {1, 2, 3};
        //int[] A= {-1, -3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));
        if (A[A.length - 1] <= 0) {
            return 1;
        }
        int ans = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] == ans) {
                ans++;
            }
        }
        return ans;
    }
}
