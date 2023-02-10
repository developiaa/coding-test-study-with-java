package programmers.level2.전화번호_목록;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"}; // false
//        String[] phone_book = {"123","456","789"}; // true
//        String[] phone_book = {"12","123","1235","567","88"}; // false
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

}
