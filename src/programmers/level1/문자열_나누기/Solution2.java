package programmers.level1.문자열_나누기;

public class Solution2 {
    public static void main(String[] args) {
//        String s = "banana"; //3
//        String s = "abracadabra"; //6
        String s = "aaabbaccccabba"; //3

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int count = 0;
        char prev = '1';
        int same = 0;
        int different = 0;
        for (char c : s.toCharArray()) {
            if (prev == '1') {
                prev = c;
                same++;
                count++;
            } else if (prev == c) {
                same++;
            } else {
                different++;
            }

            if (same == different) {
                prev = '1';
                same = 0;
                different = 0;
            }
        }

        return count;
    }
}
