package codility.lesson4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermCheck2 {
    public static void main(String[] args) {
        //int[] A = {4, 1, 2, 3}; //1
        int[] A = {4, 1, 3}; //0
        System.out.println(solution(A));
    }

    //순열인지(1) 아닌지(0)에 따라서 결과값 반환
    public static int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] != i) {
                // 1부터 시작하기 때문에 배열 인덱스 0번째와 1의 값이 같아야한다.
                // 중간 값이 하나라도 없으면 순열이 아니므로 0반환
                return 0;
            }
        }
        return 1;
    }

}
