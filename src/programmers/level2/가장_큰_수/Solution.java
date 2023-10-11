package programmers.level2.가장_큰_수;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};	// 6210
//        int[] numbers = {3, 30, 34, 5, 9};	// 9534330
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    System.out.println(reversed-original);
                    System.out.println(reversed);
                    System.out.println(original);
                    System.out.println();
                    return reversed - original;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
    }

}
