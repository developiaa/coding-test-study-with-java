package programmers.level1.둘만의_암호;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5; // happy

        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list1.add(s.charAt(i) % 97);
        }

        for (int i = 0; i < skip.length(); i++) {
            list2.add(skip.charAt(i) % 97);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < index; j++) {
                do {
                    list1.set(i, list1.get(i) + 1);
                    if (list1.get(i) == 26) list1.set(i, 0);
                } while (list2.contains(list1.get(i)));
            }
            sb.append((char) (list1.get(i) + 97));
        }
        return sb.toString();
    }
}
