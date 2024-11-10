package programmers.level2.교점에_별_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Review {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};  // ["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
        System.out.println(Arrays.toString(solution(line)));
    }

    public static String[] solution(int[][] line) {
        List<Point> list = new ArrayList<>();
        // 모든 직선쌍에 대해서 반복
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = getIntersection(line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    // 정수인 경우
                    list.add(intersection);
                }
            }
        }

        Point maximumPoint = getMaximumPoint(list);
        Point minimumPoint = getMinimumPoint(list);

        int width = (int) (maximumPoint.x - minimumPoint.x + 1);
        int height = (int) (maximumPoint.y - minimumPoint.y + 1);

        char[][] arr = new char[height][width];
        for (char[] chars : arr) {
            Arrays.fill(chars, '.');
        }

        for (Point point : list) {
            int x = (int) (point.x - minimumPoint.x);
            int y = (int) (maximumPoint.y - point.y);
            arr[y][x] = '*';
        }

        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;
    }

    public static Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for (Point point : points) {
            if (point.x < x) {
                x = point.x;
            }
            if (point.y < y) {
                y = point.y;
            }
        }
        return new Point(x, y);
    }

    public static Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for (Point point : points) {
            if (point.x > x) {
                x = point.x;
            }
            if (point.y > y) {
                y = point.y;
            }
        }
        return new Point(x, y);
    }


    // 좌표 클래스
    public static class Point {
        private final long x;
        private final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 교점 구하기
    public static Point getIntersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }


}
