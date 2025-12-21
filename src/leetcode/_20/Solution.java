package leetcode._20;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                deque.offerLast(c);
            } else {
                if (deque.isEmpty()) {
                    return false;
                } else {
                    if (!getPair(deque.pollLast(), c)) {
                        return false;
                    }
                }
            }
        }
        return deque.isEmpty();
    }

    public boolean getPair(char c1, char c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        } else if (c1 == '{' && c2 == '}') {
            return true;
        } else return c1 == '[' && c2 == ']';
    }
}
