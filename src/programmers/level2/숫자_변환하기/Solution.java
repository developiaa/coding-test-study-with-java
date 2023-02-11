package programmers.level2.숫자_변환하기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5; //2

//        int x = 10;
//        int y = 40;
//        int n = 30; //1

//        int x = 2;
//        int y = 5;
//        int n = 4; //-1

        System.out.println(solution(x, y, n));
    }

    public static int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        int[] arr = new int[1000001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            int[] temp = new int[3];
            temp[0] = num + n;
            temp[1] = num * 2;
            temp[2] = num * 3;

            for (int i = 0; i < 3; i++) {
                int next = temp[i];
                if (next > y) {
                    continue;
                }
                if (arr[next] == 0 || arr[next] > arr[num] + 1) {
                    arr[next] = arr[num] + 1;
                    queue.add(next);
                }
            }
        }
        return arr[y] != 0 ? arr[y] : -1;
    }

}
