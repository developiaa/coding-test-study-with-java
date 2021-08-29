package codility.lession1;

public class BinaryGap3 {

    public static void main(String[] args) {
        System.out.println(solution(9));
        System.out.println(solution(529));
        System.out.println(solution(1041));
    }

    public static int solution(int N) {
        String N2 = Integer.toBinaryString(N);
        //1001
        //1000010001
        int max = 0;
        int count = 0;
        for (int i = 0; i < N2.length(); i++) {
            if (N2.charAt(i) == '1') {
                if (count != 0) {
                    // 처음의 1이 아닌 경우
                    if (count > max) {
                        max = count;
                    }
                    count=0;
                } else {
                    // 처음인 경우
                    count=0;
                }
            } else {
                count++;
            }
        }
        return max;
    }
}
