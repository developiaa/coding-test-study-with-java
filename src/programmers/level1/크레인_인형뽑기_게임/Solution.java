package programmers.level1.크레인_인형뽑기_게임;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4}; // 4
        //4 3 1 1 3 2 4
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (stack.size() != 0 && stack.peek() == board[i][move - 1]) {
                        count++;
                        stack.pop();
                    } else {
                        stack.push(board[i][move - 1]);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }

        return count * 2;
    }
}
