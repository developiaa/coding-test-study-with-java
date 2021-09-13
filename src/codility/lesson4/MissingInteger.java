package codility.lesson4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//77%
//O(N) or O(N * log(N))
public class MissingInteger {
    // 주어진 배열에서 나타나지 않은 가장 작은 양의 정수 출력
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2}; //5
//        int[] A = {1, 2, 3}; //4
//        int[] A = {-1, -3}; //1
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        // 가장 큰 값이 음수 일 경우 1 반환
        if (A[A.length - 1] < 0) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= A[A.length - 1]; i++) {
            set.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            set.remove(A[i]);
        }

        //중간에 missing이 발생안할 경우 최대값 +1
        if (set.isEmpty()) {
            return A[A.length - 1] + 1;
        }

        //중간에 missing이 발생할 경우 return
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();




    }

}
