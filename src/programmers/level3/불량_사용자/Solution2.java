package programmers.level3.불량_사용자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"}; //2
//        String[] banned_id = {"fr*d*", "*rodo", "******", "******"}; //3
        System.out.println(solution(user_id, banned_id));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id).filter(id -> id.matches(banned)).toArray(String[]::new))
                .toArray(String[][]::new);

        for (String[] strings : bans) {
            System.out.println(strings.length);
            for (String string : strings) {
                System.out.println("string = " + string);
            }
        }

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);

        return banSet.size();
    }

    private static void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : bans[index]) {
            if(banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }



}
