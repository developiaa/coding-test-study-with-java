package programmers.test.n2501;

public class Solution1 {
    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] start1 = {1, 0, 2, 4};
        int[] dest1 = {2, 2, 0, 5};
        int[] limit1 = {3, 17, 7, 4, 5, 17};
        System.out.println(solution(start1, dest1, limit1)); // 출력: 16
    }

    public static int solution(int[] start, int[] dest, int[] limit) {
        int N = start.length;  // 탑승 기록의 수
        int K = limit.length; // 역의 수

        int totalCost = 0; // 총 비용
        int maxStationVisited = 0; // 방문한 가장 큰 역 번호

        for (int i = 0; i < N; i++) {
            int boardingStation = start[i];
            int destinationStation = dest[i];

            // 이동한 거리 (절대값)
            int distance = Math.abs(destinationStation - boardingStation);

            // 해당 이동의 요금 계산
            int rideCost = 1 + 2 * distance;
            totalCost += rideCost;

            // 방문한 최대 역 번호 갱신
            maxStationVisited = Math.max(maxStationVisited, Math.max(boardingStation, destinationStation));
        }

        // 최종 요금은 방문한 최대 역 번호의 제한 요금 적용
        return Math.min(totalCost, limit[maxStationVisited]);
    }
}
