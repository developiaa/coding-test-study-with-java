package programmers.level3.불량_사용자;

@Deprecated(since = "구현 실패")
public class Solution {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"}; //2
        System.out.println(solution(user_id, banned_id));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        boolean[] user = new boolean[user_id.length];
        boolean[] ban = new boolean[banned_id.length];
        checkId(user_id, banned_id, user, ban);
        return answer;
    }

    private static void checkId(String[] user_id, String[] banned_id, boolean[] user, boolean[] ban) {
        for (int i = 0; i < user_id.length; i++) {
            if (user[i]) {
                continue;
            }
            for (int j = 0; j < banned_id.length; j++) {
                if (ban[j]) {
                    continue;
                }
                if (isSame(user_id[i], banned_id[j])) {
                    user[i] = true;
                    ban[j] = true;
                    checkId(user_id, banned_id, user, ban);
                    user[i] = false;
                    ban[j] = false;
                }
            }
        }
    }

    private static boolean isSame(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && s2.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
