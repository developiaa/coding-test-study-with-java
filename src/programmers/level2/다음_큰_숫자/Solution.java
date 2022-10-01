package programmers.level2.다음_큰_숫자;

public class Solution {
    public static void main(String[] args) {
        int n = 78; //83
//        int n = 15; //23
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        String binaryString = Integer.toBinaryString(n);
        int sum = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                sum++;
            }
        }

        int nSum = 0;
        int answer = 0;
        while (nSum != sum) {
            n = n + 1;
            String nBinary = Integer.toBinaryString(n);
            answer = n;
            nSum = 0;
            for (int i = 0; i < nBinary.length(); i++) {
                if (nBinary.charAt(i) == '1') {
                    nSum++;
                }
            }
        }

        return answer;
    }
}
