package basic.nTest2;

public class test2_2 {
    public static void main(String[] args) {
        int[] A = {6, 1, 4, 6, 3, 2, 7, 4};
//        int[] A = {10, 19, 15};
        int K = 3;
        int L = 2; //24
        System.out.println(solution(A, K, L));
    }

    public static int solution(int[] A, int K, int L) {
        int ans1 = findMaximumApplesImpl(A, K, L);
        int ans2 = findMaximumApplesImpl(A, K, L);
        return Math.max(ans1, ans2);
    }

    public static int findMaximumApplesImpl(int[] A, int k, int l) {
        if (k + l > A.length) {
            return -1;
        }
        int[] sum = new int[1000];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        int max = -1;
        int x = 0, y = 0;
        for (int a = 0; a + k - 1 < A.length; a++) {
            if (a > 0)
                x = sum[a + k - 1] - sum[a - 1];
            else
                x = sum[a + k - 1];
            for (int b = a + k; b + l - 1 < A.length; b++) {
                if (b > 0)
                    y = sum[b + l - 1] - sum[b - 1];
                else
                    y = sum[b + l - 1];
                if (x + y > max) {
                    max = x + y;
                }
            }
        }
        return max;
    }
}
