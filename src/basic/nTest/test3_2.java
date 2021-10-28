package basic.nTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test3_2 {
    public static void main(String[] args) {
//        String S = "CODILITY";
//        String S = "ACAX";
        String S = "ACACA";
        System.out.println(solution(S));
    }

    public static int solution(String S) {
        Set<String> set = new HashSet<>();
        int count = 0;
        //1글자일경우
//        count = S.length();
//        System.out.println(count);

        //n글자씩 빠진 경우
        int m = 0;
        for (int i = m + 1; i <= S.length(); i++) {

            String temp = S.substring(m, i);
            System.out.println(temp);
            if (i == S.length()) {
                m++;
                i = m;
            }
//            if (temp.length() != 1) {
            count += countSet(temp);
//            }
        }
        return count;
    }

    public static int countSet(String S) {
        Map<String, Integer> map = new HashMap<>();
        int count=0;
        for (int i = 0; i < S.length(); i++) {
            String temp = String.valueOf(S.charAt(i));
            if (map.containsKey(temp)) {
                Integer integer = map.get(temp);
                map.put(temp, ++integer);
            } else {
                map.put(temp, 1);
            }
        }
        System.out.println(map);
        for (String s : map.keySet()) {
            if(map.get(s)==1){
                count++;
            }
        }
        System.out.println(count);
        System.out.println();
        return count;
    }
}
