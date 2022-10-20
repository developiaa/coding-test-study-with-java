package programmers.level2.예상_대진표;

// hard
public class Solution {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;  // 3
        System.out.println(solution(n, a, b));
    }

    //4 return here
    //4 6
    //1 4 6 7
    //1 2 3 4 5 6 7 8

    //2
    //2 3 return here
    //1 2 3 4
    public static int solution(int n, int a, int b) {
        int answer = 0;
        do {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        } while (a != b);
        return answer;
    }

}
