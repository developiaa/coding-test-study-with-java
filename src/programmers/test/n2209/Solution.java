package programmers.test.n2209;

public class Solution {
    public static void main(String[] args) {
//        int N = 268; //5268
//        int N = 948; //9548
//        int N = 670; //6750
//        int N = 676; //6765
//        int N = 0; //50
//        int N = -999; //-5999
//        int N = -111; //-1115
//        int N = -151; //-1515
        int N = -146; //-1456
        System.out.println(solution(N));
    }

    public static int solution(int N) {
        String s = String.valueOf(N);
        if (N >= 0) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (5 >= Integer.parseInt(String.valueOf(c))) {
                    return Integer.parseInt(s.substring(0, i) + "5" + s.substring(i));
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (i == 0) {
                    continue;
                }
                char c = s.charAt(i);
                if (5 < Integer.parseInt(String.valueOf(c))) {
                    return Integer.parseInt(s.substring(0, i) + "5" + s.substring(i));
                }
            }
        }
        return Integer.parseInt(s + "5");
    }
}
