package programmers.level1.소수_찾기;

@Deprecated(since = "시간 초과 실패")
public class Solution {
    public static void main(String[] args) {
        int n = 10; // 4
//        int n = 5; //3
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                if (i != j && i % j == 0) {
                    break;
                }

                if (i == j && i % j == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

