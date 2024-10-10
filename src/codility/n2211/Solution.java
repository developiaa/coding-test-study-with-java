package codility.n2211;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String s = "abaaba"; // 2
//        String s = "aabbbabaaa"; // 3
//        String s = "zyzyzyz"; //5
        String s = "abcdef"; // 1
        System.out.println(solution(s));
    }

    public static int solution(String S) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j < S.length() + 1; j++) {
                String substring = S.substring(i, j);
                System.out.println(substring);
                if (map.containsKey(substring)) {
                    map.put(substring, map.get(substring) + 1);
                } else {
                    map.put(substring, 1);
                }
            }
        }

        System.out.println(map);
        int answer = S.length();
        for (String s : map.keySet()) {
            if (answer > s.length() && map.get(s) == 1) {
                answer = s.length();
            }
        }
        return answer;
    }

    public static int solution2(String S) {
        Map<String, Integer> map = new HashMap<>();
        int n = S.length();

        // 부분 문자열 생성
        for (int len = 1; len <= n; len++) { // 길이 len 별로 처리
            for (int i = 0; i <= n - len; i++) {
                String substring = S.substring(i, i + len);
                map.put(substring, map.getOrDefault(substring, 0) + 1);
            }
        }

        // 유일한 부분 문자열 중 가장 짧은 길이 찾기
        int answer = n;
        for (String s : map.keySet()) {
            if (map.get(s) == 1 && s.length() < answer) {
                answer = s.length();
            }
        }

        return answer;
    }

}
