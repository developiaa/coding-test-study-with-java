package programmers.test.n2311;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int n = 15958; // 1958
//        int n = -5859; // -589
//        int n = -5000; // 0
//        int n = -515;
//        int n = 515;
//        int n = -595;
        int n = 595;
        System.out.println(solution(n));
    }

    public static int solution(int N) {
        String s = String.valueOf(N);
        char[] charArray = s.toCharArray();
        int[] temp = new int[charArray.length];
        Arrays.fill(temp, Integer.MIN_VALUE);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '5') {
                temp[i] = Integer.parseInt(s.substring(0, i) + s.substring(i + 1));
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : temp) {
            if (max < i) {
                max = i;
            }
        }


        return max;
    }

    public static List<Integer> findIndexes(String find, String s) {
        List<Integer> list = new ArrayList<>();
        int index = s.indexOf(find);

        while (index != -1) {
            list.add(index);
            index = s.indexOf(find, index + find.length());
        }
        return list;
    }
}
