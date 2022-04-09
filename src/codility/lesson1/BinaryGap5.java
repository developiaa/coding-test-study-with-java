package codility.lesson1;

public class BinaryGap5 {
    public static void main(String[] args) {
//        int N = 1041;
//        int N = 529;
        int N = 9;
        System.out.println(solution(N));
    }

    public static int solution(int N) {
        String s = Integer.toBinaryString(N);
        int max = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (max < num) {
                    max = num;
                }
                num = 0;

            } else {
                num++;
            }
        }
        return max;
    }
}
