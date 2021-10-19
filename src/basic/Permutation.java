package basic;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        int n = 3;  //3가지 숫자중
        int r = 2;  //2개를 뽑음
        int[] input = {1, 2, 3}; //주어진 3개의 숫자
        int[] answer = new int[r]; //정답을 담을 배열
        boolean[] check = new boolean[n]; // 해당 숫자를 방문했는지 체크

        //중복 없는 순열
        permutation(n, r, input, check, answer, 0);

        System.out.println();
        //중복 있는 순열
        permutationDup(n, r, input, answer, 0);
    }

    public static void permutation(int n, int r, int[] input, boolean[] check, int[] answer, int depth) {
        //depth는 answer에 들어간 숫자의 길이
        if (depth == r) {
            //뽑을 숫자만큼 다 뽑았다면 출력하고 종료
            System.out.println(Arrays.toString(answer));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true; //중복체크
                answer[depth] = input[i];
                permutation(n, r, input, check, answer, depth + 1);
                check[i] = false;
            }

        }
    }

    public static void permutationDup(int n, int r, int[] input, int[] answer, int depth) {
        if (depth == r) {
            System.out.println(Arrays.toString(answer));
            return;
        }

        for (int i = 0; i < n; i++) {
            answer[depth] = input[i];
            permutationDup(n, r, input, answer, depth + 1);
        }
    }
}
