package baekjoon.String._1919;

import java.util.Arrays;
import java.util.Scanner;

// 정답은 맞지만 배열을 사용하는 부분이 훨씬 효율적임
public class Main_review_250809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] first = sc.next().toCharArray();
        char[] second = sc.next().toCharArray();

        int count = 0;
        Arrays.sort(first);
        Arrays.sort(second);
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex != first.length && secondIndex != second.length) {
            if (first[firstIndex] - 'a' > second[secondIndex] - 'a') {
                count++;
                secondIndex++;
                continue;
            }

            if (first[firstIndex] - 'a' < second[secondIndex] - 'a') {
                count++;
                firstIndex++;
                continue;
            }

            if (first[firstIndex] - 'a' == second[secondIndex] - 'a') {
                firstIndex++;
                secondIndex++;
            }
        }

        while (firstIndex != first.length) {
            count++;
            firstIndex++;
        }

        while (secondIndex != second.length) {
            count++;
            secondIndex++;
        }

        System.out.println(count);
    }
}
