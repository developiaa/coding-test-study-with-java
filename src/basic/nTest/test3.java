package basic.nTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test3 {
    public static void main(String[] args) {
        String S = "CODILITY"; //96
//        String S = "ACAX"; //16
//        String S = "ACACA";
        System.out.println(solution2(S));
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

    public static int solution2(String S) {
        int MOD = 1_000_000_007;
        int n = S.length();
        int[] prev = new int[n];
        int[] next = new int[n];
        int[] lastSeen = new int[26]; // 각 문자의 이전 등장 위치
        int[] firstSeen = new int[26]; // 각 문자의 다음 등장 위치

        // 초기화
        for (int i = 0; i < 26; i++) {
            lastSeen[i] = -1; // 초기값: 등장하지 않음
            firstSeen[i] = n; // 초기값: 등장하지 않음
        }

        // 이전 등장 위치 계산
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            int index = c - 'A';
            prev[i] = lastSeen[index];
            lastSeen[index] = i;
        }

        System.out.println(Arrays.toString(prev));
        System.out.println(Arrays.toString(lastSeen));

        // 다음 등장 위치 계산
        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            int index = c - 'A';
            next[i] = firstSeen[index];
            firstSeen[index] = i;
        }

        // UNI(S') 합 계산
        long result = 0;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            int index = c - 'A';

            // 현재 문자가 기여하는 서브스트링의 개수
            long left = i - prev[i];
            long right = next[i] - i;
            result = (result + (left * right) % MOD) % MOD;
        }

        // 결과는 항상 양수여야 하므로 추가 처리
        result = (result + MOD) % MOD;
        return (int) result;
    }
}
