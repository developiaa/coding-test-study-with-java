package programmers.level2.소수_찾기;

import java.util.*;

@Deprecated(since = "구현 실패")
public class Solution {
    public static void main(String[] args) {
        String numbers = "17"; // 3   // 7 17 71
//        String numbers = "011"; // 2    // 11, 101
        System.out.println(solution(numbers));
    }


    public static int solution(String numbers) {
        int answer = 0;
        // 나올 수 있는 경우의 수 파악
        Set<String> result = generate("", numbers);
        System.out.println(result);

        Set<Integer> set = new HashSet<>();
        for (String s : result) {
            if (!s.equals("")) {
                set.add(Integer.parseInt(s));
            }

        }
        System.out.println("set = " + set);


        // 소수인지 판단
        for (Integer i : set) {
            if (isPrime(i)) {
                System.out.println(i);
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Set<String> generate(String word, String numbers) {
        Set<String> words = new HashSet<>();
        words.add(word);

        if (word.length() == numbers.length()) {
            return words;
        }

        String[] split = numbers.split("");
        for (String s : split) {
            words.addAll(generate(word + s, numbers));
        }
        return words;
    }
}
