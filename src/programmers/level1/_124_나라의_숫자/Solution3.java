package programmers.level1._124_나라의_숫자;

public class Solution3 {
    public static void main(String[] args) {
//        int n = 1; //1
//        int n = 2; //2
//        int n = 3; //4
//        int n = 4; //11
        int n = 25; //221
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        String[] arr = {"4", "1", "2"};
        String answer = "";
        while (n > 0) {
            answer = arr[n % 3] + answer;
            n = (n - 1) / 3;
        }

        return answer;
    }
}
