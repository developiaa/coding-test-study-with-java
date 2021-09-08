package codility.lesson1;

import java.util.Scanner;

public class BinaryGap2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        System.out.println(solution(number));
    }
    static int solution(int N) {
        // 10 -> 2
        String N2 = Integer.toBinaryString(N);

        int result = 0;
        int count = 0;

        for(int i=0; i<N2.length(); i++) {
            if(N2.charAt(i)=='1') {
                if(count!=0) // 사이값 구하기
                    result = result<count ? count : result;
                count = 0;
                continue;
            }
            // 1이 아니면 count++
            count++;
        }

        return result;
    }
}
