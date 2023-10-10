package programmers.level1.문자열_내림차순으로_배치하기;


public class Solution2 {
    public static void main(String[] args) {
        String s = "Zbcdefg"; // gfedcbZ
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

}
