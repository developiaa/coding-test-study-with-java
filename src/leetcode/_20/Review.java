package leetcode._20;

public class Review {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int head = -1;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[++head] = ')';
            } else if (c == '{') {
                stack[++head] = '}';
            } else if (c == '[') {
                stack[++head] = ']';
            } else {
                if (head == -1 || stack[head--] != c) {
                    return false;
                }
            }
        }

        return head == -1;

    }
}
