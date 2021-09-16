package codility.lesson1;

public class BinaryGap4 {
    public static void main(String[] args) {
        System.out.println(solution(1041)); //5
    }

    public static int solution(int N) {
        String s = Integer.toBinaryString(N);

        int count = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (count <= temp) {
                    count = temp;
                }
                temp = 0;

            } else {
                temp++;
            }
        }
        return count;
    }
}
