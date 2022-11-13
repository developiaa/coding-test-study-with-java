package programmers.test.n2209;

public class Solution_2 {
    public static void main(String[] args) {
        int a = -460;
        System.out.println(solution(a));
    }

    public static int solution(int N) {
        String s = String.valueOf(N);
        if (N >= 0) {
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                int i1 = s.charAt(i) - '0';
                if (5 >= i1) {
                    break;
                }

                index++;
            }

            System.out.println("index : " + index);

            for (int i = 0; i < s.length(); i++) {
                if (i == index) {
                    return Integer.parseInt(s.substring(0, index) + 5 + s.substring(index));
                }
            }
            return Integer.parseInt(s + 5);
        } else {
            s = s.substring(1);
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                int i1 = s.charAt(i) - '0';
                if (5 <= i1) {
                    break;
                }

                index++;
            }

            System.out.println("index : " + index);

            for (int i = 0; i < s.length(); i++) {
                if (i == index) {
                    return Integer.parseInt("-" + s.substring(0, index) + 5 + s.substring(index));
                }
            }
            return Integer.parseInt("-" + s + 5);
        }

    }
}
