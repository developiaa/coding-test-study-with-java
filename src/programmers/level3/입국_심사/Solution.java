package programmers.level3.입국_심사;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10}; // 28
        System.out.println(solution2(n, times));
    }

    public static long solution(int n, int[] times) {
        long start = 0;
        long end = 1000_000_000_000_000_000L;
        while (end > start) {
            long mid = (start + end) / 2;
            if (isValid(mid, n, times)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static boolean isValid(long t, int n, int[] times) {
        long c = 0;
        for (int time : times) {
            c += t / time;
        }
        return c >= n;
    }

    public static long solution2(int n, int[] times) {
        long start = 0;
        long end = 1000_000_000_000_000_000L;
        while (end > start) {
            long mid = (start + end) / 2;
            long value = getData(mid, times);
            if (value >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static long getData(long t, int[] times) {
        long count = 0;
        for (int time : times) {
            count += t / time;
        }
        return count;
    }

}
