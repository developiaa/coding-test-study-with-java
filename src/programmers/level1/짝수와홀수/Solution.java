package programmers.level1.짝수와홀수;

public class Solution {
    public static void main(String[] args) {
//        int num = 3; //Odd
        int num = 4; //Even
        System.out.println(solution(num));
    }

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
