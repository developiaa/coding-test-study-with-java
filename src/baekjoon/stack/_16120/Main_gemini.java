package baekjoon.stack._16120;

import java.util.*;

public class Main_gemini {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == 'P') {
                stack.addLast('P');
            }
            else {
                // PPAP가 되려면, 스택에 P가 2개 이상 있고, 다음 글자가 P여야만 한다.
                // 1. 스택의 top 2개가 'P', 'P'인가? -> stack.size() >= 2
                // 2. 'A' 다음 문자가 'P'인가? -> i + 1 < input.length() && input.charAt(i + 1) == 'P'
                if (stack.size() >= 2 && i + 1 < input.length() && input.charAt(i + 1) == 'P') {
                    stack.removeLast(); // 스택의 P 하나를 제거 (PPAP -> P 과정)
                    i++; // 입력 문자열의 다음 'P'를 건너뜀
                } else {
                    // 위의 조건을 만족하지 않으면 절대 PPAP 문자열이 될 수 없음
                    System.out.println("NP");
                    return;
                }
            }
        }

        // 모든 연산 후 스택에 P 하나만 남아야 성공
        if (stack.size() == 1 && stack.peekLast() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
