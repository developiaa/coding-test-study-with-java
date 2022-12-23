package programmers.level1._124_나라의_숫자;

public class Solution2 {
    public static void main(String[] args) {
//        int n = 1; //1
//        int n = 2; //2
//        int n = 3; //4
//        int n = 4; //11
        int n = 25; //221
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        String answer = "";
        while (n > 0) {
            if (n % 3 == 0) {
                answer = "4" + answer;
                n--;
            } else if (n % 3 == 1) {
                answer = "1" + answer;
            } else {
                answer = "2" + answer;
            }
            n /= 3;
        }

        return answer;
    }
}
