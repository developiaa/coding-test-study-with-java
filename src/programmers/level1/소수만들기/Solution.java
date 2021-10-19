package programmers.level1.소수만들기;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4}; //1
        int[] nums = {1, 2, 7, 6, 4}; //4
        System.out.println(solution(nums));
    }

    public static int data = 0;

    public static int solution(int[] nums) {
        int answer = -1;
        boolean[] check = new boolean[nums.length];
        int n = nums.length;
        combination(n, 3, nums, check, 0);
        return data;
    }

    public static void combination(int n, int r, int[] a, boolean[] visited, int start) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += a[i];
                }
            }
            //소수인지 판단
            if (isPrimeNumber(sum)) {
                data++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(n, r - 1, a, visited, i + 1);
            visited[i] = false;
        }

    }

    public static boolean isPrimeNumber(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count == 2;
    }


}
