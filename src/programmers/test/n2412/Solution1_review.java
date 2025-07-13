package programmers.test.n2412;

import java.util.Arrays;
import java.util.Collections;

public class Solution1_review {
    public static void main(String[] args) {


        int[] P1 = {1, 4, 1};
        int[] S1 = {1, 5, 1};
        System.out.println(solution(P1, S1));  // 출력: 2

        int[] P2 = {4, 4, 2, 4};
        int[] S2 = {5, 5, 2, 5};
        System.out.println(solution(P2, S2));  // 출력: 3

        int[] P3 = {2, 3, 4, 2};
        int[] S3 = {2, 5, 7, 2};
        System.out.println(solution(P3, S3));  // 출력: 2
    }

    public static int solution(int[] P, int[] S) {
        int totalPerson = 0;
        Integer[] seats = new Integer[S.length];
        for (int i = 0; i < P.length; i++) {
            totalPerson += P[i];
            seats[i] = S[i];
        }


        Arrays.sort(seats, Collections.reverseOrder());

        int answer = 0;
        int seatUsed = 0;
        for (int i = 0; i < P.length; i++) {

            seatUsed += seats[i];
            answer++;

            if (seatUsed >= totalPerson) {
                break;
            }
        }
        return answer;

    }
}
