package programmers.test.n;

import java.util.*;

public class Solution3 {
    public static List<String> list = new ArrayList<>();
    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        int A = 1;
        int B = 8;
        int C = 3;
        int D = 2; //6

//        int A = 2;
//        int B = 3;
//        int C = 3;
//        int D = 2; //3

//        int A = 6;
//        int B = 2;
//        int C = 4;
//        int D = 7; //0
        System.out.println(solution(A, B, C, D));
    }

    public static int solution(int A, int B, int C, int D) {
        String[] first = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        String[] second = {"0", "1", "2", "3", "4", "5"};
        String[] third = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};


        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                for (int k = 0; k < third.length; k++) {
                    String temp = first[i] + second[j] + third[k];
                    list.add(temp);
                }
            }
        }

        int[] input = {A, B, C, D};
        int[] answer = new int[4];
        permutation(4, 4, input, new boolean[4], answer, 0);

        int count =0;
        for (String s : set) {
            if (list.contains(s)) {

                count++;
            }
        }
        return count;

    }

    public static void permutation(int n, int r, int[] input, boolean[] check, int[] answer, int depth) {
        //depth는 answer에 들어간 숫자의 길이
        if (depth == r) {
            //뽑을 숫자만큼 다 뽑았다면 출력하고 종료
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.length; i++) {
                sb.append(String.valueOf(answer[i]));
            }

            set.add(sb.toString());

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

}
