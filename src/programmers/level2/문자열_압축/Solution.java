package programmers.level2.문자열_압축;

public class Solution {
    public static void main(String[] args) {
        String s = "aabbaccc"; // 7
//        String s = "ababcdcdababcdcd"; // 9
//        String s = "abcabcdede"; // 8
//        String s = "abcabcabcabcdededededede"; // 14
//        String s = "xababcdcdababcdcd"; // 17
        System.out.println(solution(s));
//        System.out.println(convert(s));
    }

    // 안 됨 (66점)
//    public static int solution(String s) {
//        int minLength = s.length();
//        for (int i = 1; i <= s.length() / 2; i++) {
//            int temp = 1;
//            String firstString = s.substring(0, i);
//            StringBuilder sb = new StringBuilder();
//            for (int j = i; j < s.length(); j = i + j) {
//                String s1 = s.substring(j, Math.min(j + i, s.length()));
//
//                if (firstString.equals(s1)) {
//                    temp++;
//                } else {
//                    if (temp != 1) {
//                        sb.append(temp);
//                    }
//                    sb.append(firstString);
//                    temp = 1;
//                }
//
//                if (j >= s.length() - i) {
//                    if (temp != 1) {
//                        sb.append(temp);
//                    }
//                    sb.append(s1);
//                }
//                firstString = s1;
//            }
//            minLength = Math.min(minLength, sb.toString().length());
//        }
//        return minLength;
//    }


    public static int solution(String s) {
        int minLength = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            int temp = 1;
            String firstString = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = i; j <= s.length(); j = i + j) {
                String s1 = s.substring(j, Math.min(j + i, s.length()));

                if (firstString.equals(s1)) {
                    temp++;
                } else {
                    if (temp != 1) {
                        sb.append(temp);
                    }
                    sb.append(firstString);
                    firstString = s1;
                    temp = 1;
                }
            }
            sb.append(firstString);
            minLength = Math.min(minLength, sb.toString().length());
        }
        return minLength;
    }

}
