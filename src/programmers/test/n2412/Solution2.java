package programmers.test.n2412;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int[] blocks = {2, 6, 8, 5}; // 3
//        int[] blocks = {1, 5, 5, 2, 6}; // 4
//        int[] blocks = {1, 1}; // 2

        System.out.println(solution3(blocks));
    }

    public static int solution4(int[] blocks) {
        int n = blocks.length;
        int[] rightReach = new int[n];
        int[] leftReach = new int[n];

        // 왼쪽에서 오른쪽으로 최대 도달 가능 범위 계산
        rightReach[0] = 0;
        for (int i = 1; i < n; i++) {
            if (blocks[i] >= blocks[i - 1]) {
                rightReach[i] = rightReach[i - 1] + 1;
            } else {
                rightReach[i] = 0;
            }
        }

        // 오른쪽에서 왼쪽으로 최대 도달 가능 범위 계산
        leftReach[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (blocks[i] >= blocks[i + 1]) {
                leftReach[i] = leftReach[i + 1] + 1;
            } else {
                leftReach[i] = 0;
            }
        }

        // 최대 거리 계산
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            maxDistance = Math.max(maxDistance, rightReach[i] + leftReach[i] + 1);
        }

        return maxDistance;
    }

    public static int solution3(int[] blocks) {
        int n = blocks.length;

        // 왼쪽 이동 가능 거리
        int[] left = new int[n];
        left[0] = 0; // 첫 블록에서 왼쪽으로 이동할 수 없음
        for (int i = 1; i < n; i++) {
            if (blocks[i] >= blocks[i - 1]) {
                left[i] = left[i - 1];
            } else {
                left[i] = i;
            }
        }

        // 오른쪽 이동 가능 거리
        int[] right = new int[n];
        right[n - 1] = n-1;
        for (int i = n - 2; i >= 0; i--) {
            if (blocks[i] >= blocks[i + 1]) {
                right[i] = right[i + 1];
            } else {
                right[i] = i;
            }
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));


        // 최대 거리 계산
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            // 왼쪽 + 오른쪽 + 현재 블록
            maxDistance = Math.max(maxDistance, right[i]-left[i] + 1);
        }

        return maxDistance;
    }


    public static int solution2(int[] blocks) {
        int n = blocks.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // 왼쪽으로 갈 수 있는 범위 계산
        for (int i = 1; i < n; i++) {
            if (blocks[i] >= blocks[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }

        // 오른쪽으로 갈 수 있는 범위 계산
        for (int i = n - 2; i >= 0; i--) {
            if (blocks[i] >= blocks[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        // 최대 거리 계산
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            maxDistance = Math.max(maxDistance, left[i] + right[i] + 1);
        }

        return maxDistance;
    }


    public static int solution(int[] blocks) {
        int length = blocks.length;
        int[] j = new int[length];
        int[] k = new int[length];

        for (int i = 1; i < length; i++) {
            if (blocks[i] >= blocks[i - 1]) {
                j[i] = j[i - 1];
            } else {
                j[i] = 0;
            }
        }

        for (int i = blocks.length - 2; i >= 0; i--) {
            if (blocks[i] >= blocks[i + 1]) {
                k[i] = k[i + 1] + 1;
            } else {
                k[i] = 0;
            }
        }

        System.out.println(Arrays.toString(j));
        System.out.println(Arrays.toString(k));

        int maxDistance = 0;
        for (int i = 0; i < blocks.length; i++) {
            maxDistance = Math.max(maxDistance, j[i] + k[i] + 1);
        }

        return maxDistance;
    }


}
