package programmers.level1.나머지가_1이_되는_수_찾기;

public class Solution {
    public static void main(String[] args) {
//        int n = 10; //3
        int n = 12; //11
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int min = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                min = i;
                break;
            }
        }
        return min;
    }
}
