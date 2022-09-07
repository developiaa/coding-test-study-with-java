package programmers.level1.부족한_금액_계산하기;

public class Solution {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        // result 10
        System.out.println(solution(price, money, count));
    }

    public static long solution(int price, int money, int count) {
        long temp = (((long) count * (count + 1)) / 2);
        long total = price * temp;

        if (money - total >= 0) {
            return 0;
        } else {
            return total - money;
        }
    }
}
