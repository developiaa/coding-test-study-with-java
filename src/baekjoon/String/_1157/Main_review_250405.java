package baekjoon.String._1157;

import java.util.Scanner;

public class Main_review_250405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = getAlphabetCount(str.toUpperCase());

        char answer = '?';
        int max = -1;
        // 최대값을 구한다
        for (int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                answer = (char) ('A' + i);
            }else if(max == arr[i]){
                answer = '?';
            }
        }
        System.out.println(answer);
    }

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }
        return count;
    }
}
