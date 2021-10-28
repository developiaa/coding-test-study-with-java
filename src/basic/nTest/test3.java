package basic.nTest;

import java.util.HashSet;
import java.util.Set;

public class test3 {
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
        count = S.length();
        System.out.println(count);

        //n글자씩 빠진 경우
        int m = 0;
        for (int i = m + 1; i <= S.length(); i++) {

            String temp = S.substring(m, i);
            System.out.println(temp);
            if (i == S.length()) {
                m++;
                i = m + 1;
            }


            if (temp.length() != 1) {
                count += countSet(temp);
            }


        }
        return count;
    }

    public static int countSet(String S) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            String temp = String.valueOf(S.charAt(i));
            if (!set.contains(temp)) {
                //포함되어 있지 않은 경우
                set.add(temp);
            } else {
                //포함되어 있는 경우
                set.remove(temp);
            }
        }
        System.out.println(set.size());
        return set.size();
    }
}
