package baekjoon.recursion._1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int L;
    public static int C;
    public static char[] input;
    public static char[] password;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        input = new char[C];
        password = new char[L];

        for (int i = 0; i < C; i++) {
            input[i] = sc.next().charAt(0);
        }

        Arrays.sort(input);
        generate(0, 0, 0);
    }

    /**
     * @param length 현재 패스 워드의 길이
     * @param index 입력으로 주어진 글자 중에서 몇번째 글자를 사용 중인지
     * @param vowelCnt 모음의 개수
     */
    public static void generate(int length, int index, int vowelCnt) {
        if (length == L) {
            if (vowelCnt >= 1 && L - vowelCnt >= 2) {
                System.out.println(password);
            }
            return;
        }

        if (index < C) {
            // password에 input[index] 사용 하는 경우
            password[length] = input[index];
            int v = isVowel(input[index]) ? 1 : 0;
            generate(length + 1, index + 1, vowelCnt + v);

            // password에 input[index] 사용 하지 않는 경우
            password[length] = 0;
            generate(length, index + 1, vowelCnt);
        }
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
