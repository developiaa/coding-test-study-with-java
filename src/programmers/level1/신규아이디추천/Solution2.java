package programmers.level1.신규아이디추천;

public class Solution2 {
    public static void main(String[] args) {
        String id = "...!@BaT#*..y.abcdefghijklm";
//        String id = "z-+.^.";
//        String id = "abcdefghijklmn.p";
//        String id = "=.=";
        System.out.println(solution(id));
    }

    public static String solution(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        newId = newId.replaceAll("\\.+", ".");
        newId = newId.replaceAll("^\\.+|\\.+$", "");
        if (newId.isEmpty()) {
            newId = "a";
        }

        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$", "");
        }

        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }

        return newId;
    }
}
