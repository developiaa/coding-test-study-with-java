package codility.lesson7;

import java.util.Stack;

public class StoneWall {
    public static void main(String[] args) {
//        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8}; // 7
        int[] H = {8, 8, 5, 7}; // 3
        System.out.println(solution(H));
    }


    public static int solution(int[] H) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < H.length; i++) {
            if (stack.empty() || stack.peek() < H[i]) {
                //여기까진 쉬움
                count++;
                stack.add(H[i]);
            } else if (stack.peek() > H[i]) {
                //이게 포인트
                stack.pop();
                i--;
            }

        }
        return count;
    }
}
