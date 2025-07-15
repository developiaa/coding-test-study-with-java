package baekjoon.graph._1941;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] students = new int[25];
    static boolean[] check = new boolean[25];

    static List<Integer> pick = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            String str = sc.next();
            for (int j = 0; j < 5; j++) {
                if (str.charAt(j) == 'S') {
                    students[cnt] = 1; // 이다솜파
                } else {
                    students[cnt] = 0; // 임도연파
                }
                cnt++;
            }
        }

        int princess = nextCombination(0);
        System.out.println(princess);
    }

    static int nextCombination(int studentNum) {
        // base case
        if (pick.size() == 7) {
            // 이다솜파의 인원이 4명이상인지
            int cnt = 0;
            for (int i = 0; i < 7; i++) {
                if (students[pick.get(i)] == 1) cnt++;
            }
            if (cnt < 4) return 0;

            for (int i = 0; i < 7; i++) {
                check[i] = false;
            }

            if (dfs(0) == 7) return 1;
            return 0;
        }

        // 25명의 학생을 다 순열 생성에 사용해봤는데, 7명이 모이지 않는 경우 -> 종료
        if (studentNum >= 25) return 0;

        // recursive case
        // 조합의 개수
        int ret = 0;
        // studentNum 번째 학생을 포함하지 않는 경우
        ret += nextCombination(studentNum + 1);
        // studentNum 번째 학생을 포함하는 경우
        pick.add(studentNum);
        ret += nextCombination(studentNum + 1);
        pick.remove(pick.size() - 1);
        return ret;
    }

    static int dfs(int studentNum) {
        int count = 1;
        check[studentNum] = true;
        int me = pick.get(studentNum);
        for (int i = 1; i < 7; i++) {
            int you = pick.get(i);
            if (!check[i] && isFriend(me, you)) {
                count += dfs(i);
            }
        }
        return count;
    }

    static boolean isFriend(int a, int b) {
        int diff = Math.abs(a - b);
        int max = Math.max(a, b);

        if (diff == 1 && max % 5 != 0) return true;
        return diff == 5;
    }

}
