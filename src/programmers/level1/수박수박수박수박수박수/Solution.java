package programmers.level1.수박수박수박수박수박수;

public class Solution {
    public static void main(String[] args) {
        int n = 3; //수박수
//        int n = 4; //수박수박
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                stringBuilder.append("수");
            } else {
                stringBuilder.append("박");
            }
        }
        return stringBuilder.toString();
    }
}
