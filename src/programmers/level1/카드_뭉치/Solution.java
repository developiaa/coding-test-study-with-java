package programmers.level1.카드_뭉치;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"}; // Yes

//        String[] cards1 = {"i", "water", "drink"};
//        String[] cards2 = {"want", "to"};
//        String[] goal = {"i", "want", "to", "drink", "water"}; // No
        System.out.println(solution(cards1, cards2, goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Queue<String> answerQueue = new LinkedList<>();

        Collections.addAll(queue1, cards1);
        Collections.addAll(queue2, cards2);
        Collections.addAll(answerQueue, goal);

        while (!answerQueue.isEmpty()) {
            String card1 = queue1.peek();
            String card2 = queue2.peek();
            String answerString = answerQueue.peek();
            if (answerString.equals(card1)) {
                queue1.remove();
                answerQueue.remove();
            } else if (answerString.equals(card2)) {
                queue2.remove();
                answerQueue.remove();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
