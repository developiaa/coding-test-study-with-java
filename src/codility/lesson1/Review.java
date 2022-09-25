package codility.lesson1;

public class Review {
    public static void main(String[] args) {
//        int N = 1041; // 5
        int N = 32; // 5
        System.out.println(solution(N));
    }

    public static int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int max = 0;
        int temp = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (max < temp) {
                    max = temp;
                }
                temp = 0;
            } else {
                temp++;
            }
        }
        return max;
    }
}
