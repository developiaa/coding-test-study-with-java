package baekjoon.array._10431;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1 0
 * 2 190
 * 3 19
 * 4 171
 */
public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalLine = Integer.parseInt(sc.nextLine());
        String[][] matrix = new String[20][totalLine];
        for (int i = 0; i < totalLine; i++) {
            matrix[i] = sc.nextLine().split(" ");
        }

        int[][] answer = new int[2][totalLine];
        for (int i = 0; i < totalLine; i++) {
            int count = 0;
            for (int j = 1; j < 20; j++) {
                for (int k = j + 1; k < 20; k++) {
                    String temp = "0";
                    if (Integer.parseInt(matrix[i][j]) > Integer.parseInt(matrix[i][k])) {
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i][k];
                        matrix[i][k] = temp;
                        count++;
                    }
                }
            }
            System.out.println(count);
            answer[1][i] = count;
        }

        for (int i = 0; i < 1; i++) {
            System.out.print(Arrays.toString(answer[i]));
        }
    }
}
