package programmers.level1.둘만의_암호;


public class Solution2 {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5; // happy

        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char temp = c;
            int count = 0;
            while (count < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    count++;
                }
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
