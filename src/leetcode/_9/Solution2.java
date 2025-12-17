package leetcode._9;

public class Solution2 {
    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        // [Fast-Fail] Edge Case 처리
        // 1. 음수는 Palindrome이 될 수 없음
        // 2. 0이 아니면서 0으로 끝나는 숫자(예: 10, 20)는 Palindrome이 될 수 없음
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // [Core Logic] 숫자의 절반까지만 뒤집기
        // 원본 숫자(x)가 뒤집은 숫자(reversedHalf)보다 작아지면 절반을 넘어선 것임
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // [Result Check]
        // 1. 짝수 길이 (예: 1221) -> x: 12, reversedHalf: 12 -> 같으면 True
        // 2. 홀수 길이 (예: 121) -> x: 1, reversedHalf: 12 -> 가운데 숫자(2)를 버리고(reversedHalf / 10) 비교 -> 같으면 True
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
