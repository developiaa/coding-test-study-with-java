package programmers.level2.소수_찾기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 최적화2
public class Solution4 {
    public static void main(String[] args) {
        String numbers = "17"; // 3   // 7 17 71
//        String numbers = "011"; // 2    // 11, 101
        System.out.println(solution(numbers));
    }


    public static int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        boolean[] isUsed = new boolean[numbers.length];
        getPrimes(0, numbers, isUsed, primes);
        return primes.size();
    }

    private static void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime(acc)) {
            primes.add(acc);
        }

        // 점화식
        for (int i = 0; i < numbers.length; i++) {
            if(isUsed[i]) continue;
            int nextAcc = acc * 10 + numbers[i];
            isUsed[i] = true;
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
