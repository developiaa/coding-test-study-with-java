package programmers.level1.소수_찾기;

public class Solution3 {
    public static void main(String[] args) {
//        int n = 10; // 4
        int n = 1000000; // 78498
//        int n = 5; //3
        System.out.println(solution(n));
    }

    // 에라토스테네스의 체
    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= (int) Math.sqrt(n); ++i) {
            if (arr[i] == 1) continue;
            for (int j = i + i; j <= n; j += i) {
                arr[j] = 1;
            }
        }

        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] != 1) ++answer;
        }

        return answer;
    }
}

