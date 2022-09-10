package programmers.level1.서울에서_김서방_찾기;

public class Solution {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"}; // "김서방은 1에 있다"
        System.out.println(solution(seoul));
    }

    public static String solution(String[] seoul) {
        int index = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }

        return "김서방은 " + index + "에 있다";
    }
}
