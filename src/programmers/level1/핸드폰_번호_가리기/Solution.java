package programmers.level1.핸드폰_번호_가리기;

public class Solution {
    public static void main(String[] args) {
        String phone_number = "01012345678"; //5678
        System.out.println(solution(phone_number));
    }

    public static String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone_number.length(); i++) {
            if (i < phone_number.length() - 4) {
                sb.append("*");
            } else {
                sb.append(phone_number.charAt(i));
            }
        }
        return sb.toString();
    }
}
