package programmers.level2.다음_큰_숫자;

public class Solution2 {
    public static void main(String[] args) {
        int n = 78; //83
//        int n = 15; //23
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int bitCount = Integer.bitCount(n);

        int answer;
        while (true) {
            n++;
            if (Integer.bitCount(n) == bitCount) {
                answer = n;
                break;
            }
        }

        return answer;
    }
}
