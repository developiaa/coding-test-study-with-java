package programmers.level2.전화번호_목록;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"}; // false
//        String[] phone_book = {"123","456","789"}; // true
//        String[] phone_book = {"12","123","1235","567","88"}; // false
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

}
