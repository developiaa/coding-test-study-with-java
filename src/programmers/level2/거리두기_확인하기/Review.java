package programmers.level2.거리두기_확인하기;

import java.util.Arrays;

public class Review {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        // [1, 0, 1, 1, 1]
        System.out.println(Arrays.toString(solution(places)));
    }

    // 상좌우하
    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {-1, 0, 0, 1};

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private static boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                    break;
            }
        }
        return true;
    }

    private static boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') continue;
        }
        return false;
    }

    private static boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[0].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }
}
