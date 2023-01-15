package programmers.level1.옹알이2;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        String[] babbling = {"aya", "yee", "u", "maa"}; // 1
//        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}; // 2
        String[] babbling = {"ayaaya", "ayawooaya", "ayaye", "yeye", "yemawoo", "ayaayaa"}; // 3
        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("ayaaya") || babbling[i].contains("woowoo") ||
                    babbling[i].contains("yeye") || babbling[i].contains("mama")) {
                continue;
            }

            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");
            if (babbling[i].isEmpty()) {
                answer = answer + 1;
            }
        }
        return answer;
    }
}
