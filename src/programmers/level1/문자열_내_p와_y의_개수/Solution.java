package programmers.level1.문자열_내_p와_y의_개수;

public class Solution {
    public static void main(String[] args) {
        String s = "pPoooyY"; // true
//        String s = "Pyy"; // false

        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        String s1 = s.toLowerCase();
        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'p') {
                c1++;
            } else if (s1.charAt(i) == 'y') {
                c2++;
            }
        }
        return c1 == c2;
    }

    public static boolean solution2(String s) {
        String s1 = s.toLowerCase();
        int c1 = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'p') {
                c1++;
            } else if (s1.charAt(i) == 'y') {
                c1--;
            }
        }
        return c1 == 0;
    }
}
