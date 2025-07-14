package programmers.test.n2506;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args) {
        int[] A1 = {100, 100, 100, -10}; //230
        String[] D1 = {"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"};

//        int[] A1 = {180, -50, -25, -25}; // 25
//        String[] D1 = {"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"};

//        int[] A1 = {1, -1, 0, -105, 1}; // -164
//        String[] D1 = {"2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12"};

//        int[] A1 = {100, 100, -10, -20, -30}; // 80
//        String[] D1 = {"2020-01-01", "2020-02-01", "2020-02-11", "2020-02-05", "2020-02-08"};

//        int[] A1 = {-60, 60, -40, -20}; // -115
//        String[] D1 = {"2020-10-01", "2020-02-02", "2020-10-10", "2020-10-30"};
        System.out.println(solution(A1, D1));
    }


//    public static int solution(int[] A, String[] D) {
//        int totalBalance = 0;
//
//        // 월별로 카드 지출 회수와 절대값 합계 저장
//        Map<String, Integer> cardCount = new HashMap<>();
//        Map<String, Integer> cardSum = new HashMap<>();
//
//        // 전체 잔고 계산 및 카드 지출 내역 저장
//        for (int i = 0; i < A.length; i++) {
//            totalBalance += A[i];
//            if (A[i] < 0) {
//                String month = D[i].substring(5, 7);
//                cardCount.put(month, cardCount.getOrDefault(month, 0) + 1);
//                cardSum.put(month, cardSum.getOrDefault(month, 0) + Math.abs(A[i]));
//            }
//        }
//
//        // 1월 ~ 12월 동안 수수료 체크
//        for (int m = 1; m <= 12; m++) {
//            String month = String.format("%02d", m);
//            int cnt = cardCount.getOrDefault(month, 0);
//            int sum = cardSum.getOrDefault(month, 0);
//
//            // 조건 충족되지 않으면 수수료 5 부과
//            if (cnt < 3 || sum < 100) {
//                totalBalance -= 5;
//            }
//        }
//
//        return totalBalance;
//    }


    public static int solution(int[] A, String[] D) {
        int totalBalance = 0;

        // 월별 카드 지출 횟수
        Map<String, Integer> cardSpendCountByMonth = new HashMap<>();
        // 월별 카드 지출 합계 (절대값)
        Map<String, Integer> cardSpendSumByMonth = new HashMap<>();


        for (int i = 0; i < A.length; i++) {
            totalBalance += A[i];
            if (A[i] < 0) {
                String month = D[i].substring(5, 7);
                // 지출일 경우
                cardSpendCountByMonth.put(month, cardSpendCountByMonth.getOrDefault(month, 0) + 1);
                cardSpendSumByMonth.put(month, cardSpendSumByMonth.getOrDefault(month, 0) + Math.abs(A[i]));
            }
        }

        for (int i = 1; i <= 12; i++) {
            String month = String.format("%02d", i);
            int count = cardSpendCountByMonth.getOrDefault(month, 0);
            int sum = cardSpendSumByMonth.getOrDefault(month, 0);

            if (count < 3 || sum < 100) {
                totalBalance -= 5;
            }
        }

        return totalBalance;
    }

}
