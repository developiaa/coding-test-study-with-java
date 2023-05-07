package programmers.level1.문자열_내_p와_y의_개수;

public class Solution2 {
    public static void main(String[] args) {
//        String s = "pPoooyY"; // true
        String s = "Pyy"; // false

        System.out.println(solution(s));
    }

    // 내장 라이브러리 사용, O(n)
    public static boolean solution(String s) {
        s = s.toLowerCase();

        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();

        return ps == ys;
    }

    public static boolean solution2(String s) {
        int ps = 0;
        int ys = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'p','P' -> ps++;
                case 'y','Y' -> ys++;
            }
        }

        return ps == ys;
    }

}
