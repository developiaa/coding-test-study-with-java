package programmers.level2.소수_찾기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 최적화
public class Solution3 {
    public static void main(String[] args) {
        String numbers = "17"; // 3   // 7 17 71
//        String numbers = "011"; // 2    // 11, 101
        System.out.println(solution(numbers));
    }


    public static int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        List<Integer> numbers = nums.chars()
                .map(c -> c - '0')
                .boxed()
                .toList();

        getPrimes(0, numbers, primes);
        return primes.size();
    }

    private static void getPrimes(int acc, List<Integer> numbers, Set<Integer> primes) {
        if (isPrime(acc)) {
            primes.add(acc);
        }

        // 점화식
        for (int i = 0; i < numbers.size(); i++) {
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            getPrimes(nextAcc, nextNumbers, primes);
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
